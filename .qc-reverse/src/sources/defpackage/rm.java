package defpackage;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import com.quickcursor.R;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rm extends AsyncTask {
    public final /* synthetic */ sm a;

    public rm(sm smVar) {
        this.a = smVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        File file;
        int i;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FileDescriptor fileDescriptor;
        Uri[] uriArr = (Uri[]) objArr;
        uriArr.getClass();
        sm smVar = this.a;
        long j = smVar.d;
        Uri uri = uriArr[0];
        uri.getClass();
        try {
            file = new File(smVar.getCacheDir(), "image_picker.png");
            parcelFileDescriptorOpenFileDescriptor = smVar.getContentResolver().openFileDescriptor(uri, "r");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (parcelFileDescriptorOpenFileDescriptor == null || (fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()) == null) {
            file = null;
        } else {
            FileChannel channel = new FileInputStream(fileDescriptor).getChannel();
            FileChannel channel2 = new FileOutputStream(file).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
        }
        if (file == null) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        File file2 = null;
        while (true) {
            if (file2 != null) {
                file2.delete();
            }
            File fileD = smVar.d(file, i2);
            if (fileD == null) {
                if (i2 > 0) {
                    return smVar.d(file, i3);
                }
                return null;
            }
            boolean z = true;
            if (j > 0) {
                long length = fileD.length() - j;
                i = (length > 1048576 ? 3 : length > 512000 ? 2 : 1) + i2;
            } else {
                i = i2 + 1;
            }
            int i4 = smVar.c;
            int i5 = smVar.b;
            boolean z2 = j > 0 && fileD.length() - j > 0;
            if (z2 || i5 <= 0 || i4 <= 0) {
                z = z2;
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(fileD.getAbsolutePath(), options);
                int i6 = options.outWidth;
                int i7 = options.outHeight;
                if (i6 <= i5 && i7 <= i4) {
                    z = false;
                }
            }
            if (!z) {
                try {
                    f00 f00Var = new f00(file);
                    f00 f00Var2 = new f00(fileD);
                    for (String str : kl.K0("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "Orientation")) {
                        if (f00Var.b(str) != null) {
                            f00Var2.D(str, f00Var.b(str));
                        }
                    }
                    f00Var2.z();
                } catch (Exception e2) {
                    Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e2);
                }
                return fileD;
            }
            i3 = i2;
            i2 = i;
            file2 = fileD;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        File file = (File) obj;
        super.onPostExecute(file);
        sm smVar = this.a;
        if (file == null) {
            smVar.c(R.string.error_failed_to_compress_image);
            return;
        }
        ImagePickerActivity imagePickerActivity = smVar.a;
        Uri uriFromFile = Uri.fromFile(file);
        uriFromFile.getClass();
        imagePickerActivity.getClass();
        ji jiVar = imagePickerActivity.B;
        if (jiVar != null) {
            File file2 = jiVar.b;
            if (file2 != null) {
                file2.delete();
            }
            jiVar.b = null;
        }
        uq uqVar = imagePickerActivity.C;
        if (uqVar == null) {
            fc0.S("mCropProvider");
            throw null;
        }
        File file3 = uqVar.g;
        if (file3 != null) {
            file3.delete();
        }
        uqVar.g = null;
        imagePickerActivity.F(uriFromFile);
    }
}
