/*
 * Copyright 2013 Samsung Developer Relations Team (MSCSEA)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.mscsea.chatonlib.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sec.chaton.clientapi.MessageAPI;

public class SendAppLinkMessage implements FREFunction {

	/**
	 * Send app link message
	 * 
	 * @arg String message to be sent
	 * @arg String title of the app
	 * @arg String version of the app
	 * @arg AppInfo[] app info
	 * 
	 * @param frecontext
	 * @param args
	 * @return integer
	 */
	@Override
	public FREObject call(FREContext frecontext, FREObject[] args) {
		try {
			Context context = frecontext.getActivity();
			
			String message = args[0].getAsString();
			
			String appTitle = args[1].getAsString();
			
			String appVersion = args[2].getAsString();
			
			ArrayList<Map<String,String>> params = new ArrayList<Map<String,String>>();
			
			FREArray appParams = (FREArray) args[3];
			for (int n = 0; n < appParams.getLength(); n++) {
				FREObject param = (FREObject) appParams.getObjectAt(n);
				
				String id = param.getProperty("id").getAsString();
				String os = param.getProperty("os").getAsString();
				String deviceType = param.getProperty("deviceType").getAsString();
				String installUrl = param.getProperty("installUrl").getAsString();
				String executeUri = param.getProperty("executeUri").getAsString();
				
				HashMap<String,String> p = new HashMap<String,String>();
	    		p.put("id", id);
	    		p.put("OS", os);
	    		p.put("deviceType", deviceType);
	    		p.put("installUrl", installUrl);
	    		p.put("executeUri", executeUri);
	    		
	    		params.add(p);
			}
			
			int ret = MessageAPI.sendAppLinkMessage(context, message, appTitle, appVersion, params);
			return FREObject.newObject(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
