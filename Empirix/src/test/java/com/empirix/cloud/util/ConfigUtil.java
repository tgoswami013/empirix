package com.empirix.cloud.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.empirix.cloud.helper.Constants;
import com.empirix.cloud.helper.TestBase;

public class ConfigUtil extends TestBase
{
	/**
	 * This will read properties file
	 * @author Tarun Goswami
	 * @since 2020-01-21
	 * @version 1.0
	 */
	public static void loadProperty() throws IOException
	{
		conf = new Properties();
		input = new FileInputStream(Constants.PROP_FILE);
		conf.load(input);
	}
}
