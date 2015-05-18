package com.kgd.zhen.bean;

import java.util.List;

public class test2Bean {
	
	
	
    @Override
	public String toString() {
    	return "test2Bean [a=" + a + ", b=" + b + ",c" +c + "]";
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public List<B> getB() {
		return b;
	}

	public void setB(List<B> b) {
		this.b = b;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public String a;  
	public List<B> b;  
	public C c;  

        
        
        
        public static class B {  
            @Override
			public String toString() {
            	return "B [b1=" + b1 + ", b2=" + b2 + "]";
			}
			public String getB1() {
				return b1;
			}
			public void setB1(String b1) {
				this.b1 = b1;
			}
			public String getB2() {
				return b2;
			}
			public void setB2(String b2) {
				this.b2 = b2;
			}
				public String b1;  
                 public String b2;  
       }  

       public static class C {  
        @Override
		public String toString() {
        	return "C [c1=" + c1 + ", c2=" + c2 + "]"; 
		}
		public String getC1() {
			return c1;
		}
		public void setC1(String c1) {
			this.c1 = c1;
		}
		public String getC2() {
			return c2;
		}
		public void setC2(String c2) {
			this.c2 = c2;
		}
		public String c1;  
		public String c2;  
      }  
}
