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

package co.mscsea.chatonlib;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ChatONLib implements FREExtension {

	public static final String TAG = "ChatONLib";
	
	@Override
	public FREContext createContext(String arg0) {
		Log.d(TAG, "createContext");
		return new ChatONLibContext();
	}

	@Override
	public void dispose() {
		Log.d(TAG, "dispose");
	}

	@Override
	public void initialize() {
		Log.d(TAG, "initialize");
	}
}
