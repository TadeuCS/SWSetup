package br.com.tcs.sws.domain.files;

import java.util.List;

public class ParamettersFile {
	private String host;
	private String targetPath;
	private List<String> optionsSelected;
	
	public ParamettersFile(String host, String targetPath, List<String> optionsSelected) {
		this.host = host;
		this.targetPath = targetPath;
		this.optionsSelected = optionsSelected;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public List<String> getOptionsSelected() {
		return optionsSelected;
	}

	public void setOptionsSelected(List<String> optionsSelected) {
		this.optionsSelected = optionsSelected;
	}

}
