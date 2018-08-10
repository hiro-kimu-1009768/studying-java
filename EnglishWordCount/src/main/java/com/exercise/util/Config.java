package com.exercise.util;

public class Config {
	String inputConfig = null;
	String outputConfig = null;
	String outputConfigDetail = null;

	public String getInputConfig() {
		return inputConfig;
	}

	public String getOutputConfig() {
		return outputConfig;
	}

	public String getOutputConfigDetail() {
		return outputConfigDetail;
	}

	public Config(String inputConfig, String outputConfig, String outputConfigDetail) {
		this(inputConfig, outputConfig);
		this.outputConfigDetail = outputConfigDetail;
	}

	public Config(String inputConfig, String outputConfig) {
		this.inputConfig = inputConfig;
		this.outputConfig = outputConfig;
	}

	public static Config IOConfig(String[] args) {
		if (args.length == 4) {
			if (args[0].startsWith("-i") && args[2].startsWith("-o")) {
				String[] outputConfigSplit = args[3].split("=");
				return new Config(args[1], outputConfigSplit[0], outputConfigSplit[1]);
			}
		} else if (args.length == 3) {
			if (args[0].startsWith("-i") && args[2].startsWith("-o")) {
				return new Config(args[1], args[2]);
			} else {
				return null;
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Config [inputConfig=" + inputConfig + ", outputConfig=" + outputConfig + ", outputConfigDetail="
				+ outputConfigDetail + "]";
	}
}
