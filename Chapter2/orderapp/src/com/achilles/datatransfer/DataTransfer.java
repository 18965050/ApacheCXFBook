package com.achilles.datatransfer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

public class DataTransfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("F:/––≥Ã÷˙ ÷/viewspot_beijing.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		File destFile = new File("viewspot.sql");
		if (destFile.exists()) {
			destFile.delete();
			destFile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(destFile);

		StringBuilder sb = new StringBuilder("set define off;\n\n");
		String line = br.readLine();

		int i = 0;

		while (StringUtils.isNotBlank(line)) {
			String[] lineParts = line.split("\\|");
			if (lineParts.length == 6) {
				i++;
				sb.append(
						"insert into travel.viewspot_info(spot_id,loc_key,name,address,currency,longitude,latitude,status)\n")
						.append("select travel.s_viewspot_info.nextval, a.termin_code,'").append(lineParts[0])
						.append("','").append(lineParts[5]).append("','0','").append(lineParts[3]).append("','")
						.append(lineParts[4]).append("',1 from travel.app_travel_termin_info a where a.termin_name='")
						.append(lineParts[1]).append("' and a.termin_type=2;");
				sb.append("\n\n");

				if (i % 10000 == 0) {
					sb.append("commit;\n\n");
				}
			}
			line = br.readLine();
		}
		sb.append("\n\ncommit;");
		fos.write(sb.toString().getBytes());
		fos.flush();
		fos.close();
	}
}
