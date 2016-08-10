package com.wangdi.shiweitian.product;

import android.app.Activity;

public class GouWuChe extends Activity{
        
	   String biaoTi;
	   String neiRong;
	   int jiaGe;
	   int image;
	  
	   
	   public GouWuChe(){}
	   
	   public GouWuChe(String biaoTi,String neiRong,int jiaGe,int image){
		       setbiaoTi(biaoTi);
		       setneiRong(neiRong);
		       setjiaGe(jiaGe);
		       setimage(image);
		   
	   }
	   
	   

	public void setbiaoTi(String biaoTi) {
		      this.biaoTi=biaoTi;
		
	}
       public String getbiaoTi(){
		    return this.biaoTi;
    	   
       }
       
       public void setneiRong(String neiRong){
    	       this.neiRong=neiRong;
       }
       public String getneiRong(){
    	    return this.neiRong;
       }
	
       
       
	   public void setjiaGe(int jiaGe){
		      this.jiaGe=jiaGe;
	   }
	   public int getjiaGe(){
		     return this.jiaGe;
	   }
	   
	   public void setimage(int image){
		      this.image=image;
	   }
	   public int getimage(){
		      return this.image;
	   }
	   
       
       
}
