package com.text.model;

public class PatternManagements {
	
	private String pan;
	private String addhar;
	private boolean addharfound;
	private boolean panfound;
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAddhar() {
		return addhar;
	}
	public void setAddhar(String addhar) {
		this.addhar = addhar;
	}
	public boolean isAddharfound() {
		return addharfound;
	}
	public void setAddharfound(boolean addharfound) {
		this.addharfound = addharfound;
	}
	public boolean isPanfound() {
		return panfound;
	}
	public void setPanfound(boolean panfound) {
		this.panfound = panfound;
	}
	public PatternManagements(String pan, String addhar, boolean addharfound, boolean panfound) {
		super();
		this.pan = pan;
		this.addhar = addhar;
		this.addharfound = addharfound;
		this.panfound = panfound;
	}
	public PatternManagements() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PatternManagements [pan=" + pan + ", addhar=" + addhar + ", addharfound=" + addharfound + ", panfound="
				+ panfound + "]";
	}
	
	

}
