package co.mscsea.chatonextension
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	public class ChatONExtension extends EventDispatcher
	{
		private var extContext:ExtensionContext;
		
		public static var MIME_TYPE_UNKNOWN:String 	= "unknown";
		public static var MIME_TYPE_TEXT:String 	= "text";
		public static var MIME_TYPE_IMAGE:String 	= "image";
		public static var MIME_TYPE_VIDEO:String 	= "video";
		
		public function ChatONExtension()	{
			super();
			
			extContext = ExtensionContext.createExtensionContext("co.mscsea.chaton", "");
			if (!extContext) {
				throw new Error("Native extension not found!");
			}
			
			extContext.addEventListener(StatusEvent.STATUS, onStatus);
		}
		
		private function onStatus( event:StatusEvent ):void {
			
		}
		
		public function dispose():void { 
			extContext.dispose(); 
		}
		
		private function init():void {
			extContext.call("init");
		}
		
		public function isChatONInstalled():Boolean {
			return extContext.call("isChatONInstalled");
		}
		
		public function openChatONDownloadPage():void {
			extContext.call("openChatONDownloadPage");
		}
		
		public function sendTextMessage(message:String):Number {
			return Number(extContext.call("sendTextMessage", message));
		}
		
		public function sendTextMessageWithURL(message:String, url:String):Number {
			return Number(extContext.call("sendTextMessageWithURL", message, url));
		}
		
		public function sendMultimediaMessage(uri:String, mimeType:String):Number {
			return Number(extContext.call("sendMultimediaMessage", uri, mimeType));
		}
		
		public function sendMultimediaMessageWithText(uri:String, mimeType:String, message:String):Number {
			return Number(extContext.call("sendMultimediaMessageWithText", uri, mimeType, message));
		}
		
		public function sendAppLinkMessage(message:String, appTitle:String, appVersion:String, ...args):Number {
			return Number(extContext.call("sendAppLinkMessage", message, appTitle, appVersion, args));
		}
	}
}