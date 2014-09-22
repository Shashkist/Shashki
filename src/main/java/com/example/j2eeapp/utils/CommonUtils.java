package com.example.j2eeapp.utils;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class CommonUtils {
	
	
	public static Object getBean(String beanName,FacesContext context){
	    Object bean = null;
	    
	    if(context!=null){
	         ELContext elContext = context.getELContext();
	         bean = elContext.getELResolver().getValue(elContext, null, beanName);
	    }

	    return bean;
	}


	

/**
 * Returns a copy of the object, or null if the object cannot
 * be serialized.
 */
public static Object copy(Object orig) {
    Object obj = null;
    try {
        // Write the object out to a byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(orig);
        out.flush();
        out.close();

        // Make an input stream from the byte array and read
        // a copy of the object back in.
        ObjectInputStream in = new ObjectInputStream(
            new ByteArrayInputStream(bos.toByteArray()));
        obj = in.readObject();
    }
    catch(IOException e) {
        e.printStackTrace();
    }
    catch(ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
    }
    return obj;
}

	
}
