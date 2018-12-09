package com.beans;

import java.util.StringTokenizer;

public class Date {
	 

		private int dd;
		private int mm;
		private int yy;
		
		public Date(String date){
			StringTokenizer s1 = new StringTokenizer(date,"-",false);
			yy = Integer.parseInt(s1.nextToken());
			mm = Integer.parseInt(s1.nextToken());
			dd = Integer.parseInt(s1.nextToken());
		}
				
		public Date(int dd, int mm, int yy) {
			super();
			this.dd = dd;
			this.mm = mm;
			this.yy = yy;
		}

		public String toString(){
			 String s1 = yy+"-"+mm+"-"+dd;
 			 return  s1;
		 }
		public int getDd() {
			return dd;
		}
		public void setDd(int dd) {
			this.dd = dd;
		}
		public int getMm() {
			return mm;
		}
		public void setMm(int mm) {
			this.mm = mm;
		}
		public int getYy() {
			return yy;
		}
		public void setYy(int yy) {
			this.yy = yy;
		}
		
		
}
