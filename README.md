# Java-Android-Bitmap-Image-Minimiser
This sample script helps us to reduce the size of these images when we save images to SQLite and similar databases. 
These databases may not support saving high size images. 
Therefore, if there is an image that we will save to the database in our application, we first reduce it, then convert it to a byte array consisting of 0 and 1s and make it ready to save.
