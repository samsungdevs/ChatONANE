import shutil
import os
import zipfile

shutil.copy('../ChatONExtension/bin/ChatONExtension.swc', './')
zipfile.ZipFile('ChatONExtension.swc').extractall('android/')
os.remove('android/catalog.xml')
shutil.copy('../ChatONAndroidLib/ChatONAndroidLib.jar', 'android/')
shutil.copy('../ChatONExtension/src/co/mscsea/extension.xml', './')
os.system('adt -package -target ane ChatONExtension.ane extension.xml -swc ChatONExtension.swc -platform Android-ARM -C android .')