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

import android.content.Context;
import android.net.Uri;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sec.chaton.clientapi.ChatONAPI.MimeType;
import com.sec.chaton.clientapi.MessageAPI;

public class SendMultimediaMessage implements FREFunction {

	/**
	 * Send multimedia message
	 * 
	 * @arg String uri of the multimedia file
	 * @arg String mime type of the multimedia file
	 * 
	 * @param frecontext
	 * @param args
	 * @return integer
	 */
	@Override
	public FREObject call(FREContext frecontext, FREObject[] args) {
		try {
			Context context = frecontext.getActivity();
			
			String uriString = args[0].getAsString();
			Uri uri = Uri.parse(uriString);
			
			String mimeTypeString = args[1].getAsString();
			MimeType mimeType = MimeType.valueOf(mimeTypeString);
			
			int ret = MessageAPI.sendMultiMediaMessage(context, uri, mimeType);
			return FREObject.newObject(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
