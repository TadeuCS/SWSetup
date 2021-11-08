package br.com.tcs.sws.domain.files;

import java.time.LocalDateTime;

public class DownloadedFile {
	private String name;
	private long size;
	private LocalDateTime dtModification;
	
	public DownloadedFile(String name, long size, LocalDateTime dtModification) {
		this.name = name;
		this.size = size;
		this.dtModification = dtModification;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public LocalDateTime getDtModification() {
		return dtModification;
	}
	public void setDtModification(LocalDateTime dtModification) {
		this.dtModification = dtModification;
	}
}
