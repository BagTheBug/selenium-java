package com.fb.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomValuGen {

	public String screenShotName() throws IOException {
		String fileName = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		fileName = df.format(dateobj).replace("\\s", "_").replaceAll("/", "-");
		fileName = fileName.replaceAll(":", "_") + ".jpg";
		fileName = ReadPropertiesFile.getConfigParm("ScreenshotPath") + fileName;
		return fileName;
	}
}
