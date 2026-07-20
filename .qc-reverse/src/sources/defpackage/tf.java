package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.yalantis.ucrop.UCropActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tf extends AsyncTask {
    public final WeakReference a;
    public Bitmap b;
    public final RectF c;
    public final RectF d;
    public float e;
    public final float f;
    public final int g;
    public final int h;
    public final Bitmap.CompressFormat i;
    public final int j;
    public final String k;
    public final String l;
    public final wc1 m;
    public int n;
    public int o;
    public int p;
    public int q;

    public tf(Context context, Bitmap bitmap, ua0 ua0Var, tq tqVar, wc1 wc1Var) {
        this.a = new WeakReference(context);
        this.b = bitmap;
        this.c = ua0Var.a;
        this.d = ua0Var.b;
        this.e = ua0Var.c;
        this.f = ua0Var.d;
        this.g = tqVar.a;
        this.h = tqVar.b;
        this.i = (Bitmap.CompressFormat) tqVar.d;
        this.j = tqVar.c;
        this.k = (String) tqVar.e;
        this.l = (String) tqVar.f;
        this.m = wc1Var;
    }

    public final void a() throws Throwable {
        FileChannel channel;
        ByteArrayOutputStream byteArrayOutputStream;
        int i = this.h;
        RectF rectF = this.c;
        int i2 = this.g;
        if (i2 > 0 && i > 0) {
            float fWidth = rectF.width() / this.e;
            float fHeight = rectF.height() / this.e;
            float f = i2;
            if (fWidth > f || fHeight > i) {
                float fMin = Math.min(f / fWidth, i / fHeight);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.b, Math.round(r6.getWidth() * fMin), Math.round(this.b.getHeight() * fMin), false);
                Bitmap bitmap = this.b;
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
                this.b = bitmapCreateScaledBitmap;
                this.e /= fMin;
            }
        }
        float f2 = this.f;
        if (f2 != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(f2, this.b.getWidth() / 2, this.b.getHeight() / 2);
            Bitmap bitmap2 = this.b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.b.getHeight(), matrix, true);
            Bitmap bitmap3 = this.b;
            if (bitmap3 != bitmapCreateBitmap) {
                bitmap3.recycle();
            }
            this.b = bitmapCreateBitmap;
        }
        float f3 = rectF.left;
        RectF rectF2 = this.d;
        this.p = Math.round((f3 - rectF2.left) / this.e);
        this.q = Math.round((rectF.top - rectF2.top) / this.e);
        this.n = Math.round(rectF.width() / this.e);
        this.o = Math.round(rectF.height() / this.e);
        boolean z = true;
        int iRound = Math.round(Math.max(this.n, r5) / 1000.0f) + 1;
        if (i2 <= 0 || i <= 0) {
            float f4 = iRound;
            if (Math.abs(rectF.left - rectF2.left) <= f4 && Math.abs(rectF.top - rectF2.top) <= f4 && Math.abs(rectF.bottom - rectF2.bottom) <= f4 && Math.abs(rectF.right - rectF2.right) <= f4 && f2 == 0.0f) {
                z = false;
            }
        }
        Log.i("BitmapCropTask", "Should crop: " + z);
        FileChannel fileChannel = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream = null;
        String str = this.k;
        String str2 = this.l;
        if (z) {
            f00 f00Var = new f00(str);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.b, this.p, this.q, this.n, this.o);
            Context context = (Context) this.a.get();
            Bitmap.CompressFormat compressFormat = this.i;
            if (context != null) {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2), false);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            bitmapCreateBitmap2.compress(compressFormat, this.j, byteArrayOutputStream);
                            fileOutputStream2.write(byteArrayOutputStream.toByteArray());
                            bitmapCreateBitmap2.recycle();
                            i1.i(fileOutputStream2);
                        } catch (IOException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            try {
                                Log.e("BitmapCropTask", e.getLocalizedMessage());
                                i1.i(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                i1.i(fileOutputStream);
                                i1.i(byteArrayOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            i1.i(fileOutputStream);
                            i1.i(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
                i1.i(byteArrayOutputStream);
            }
            if (compressFormat.equals(Bitmap.CompressFormat.JPEG)) {
                int i3 = this.n;
                int i4 = this.o;
                byte[] bArr = ra0.b;
                String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
                try {
                    f00 f00Var2 = new f00(str2);
                    for (int i5 = 0; i5 < 22; i5++) {
                        String str3 = strArr[i5];
                        String strB = f00Var.b(str3);
                        if (!TextUtils.isEmpty(strB)) {
                            f00Var2.D(str3, strB);
                        }
                    }
                    f00Var2.D("ImageWidth", String.valueOf(i3));
                    f00Var2.D("ImageLength", String.valueOf(i4));
                    f00Var2.D("Orientation", "0");
                    f00Var2.z();
                    return;
                } catch (IOException e4) {
                    Log.d("ImageHeaderParser", e4.getMessage());
                    return;
                }
            }
            return;
        }
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        try {
            FileChannel channel2 = new FileInputStream(new File(str)).getChannel();
            try {
                channel = new FileOutputStream(new File(str2)).getChannel();
                try {
                    channel2.transferTo(0L, channel2.size(), channel);
                    channel2.close();
                    channel2.close();
                    if (channel != null) {
                        channel.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileChannel = channel2;
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                channel = null;
            }
        } catch (Throwable th7) {
            th = th7;
            channel = null;
        }
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        Bitmap bitmap = this.b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a();
            this.b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Throwable th = (Throwable) obj;
        wc1 wc1Var = this.m;
        if (wc1Var != null) {
            UCropActivity uCropActivity = wc1Var.b;
            if (th != null) {
                uCropActivity.F(th);
                uCropActivity.finish();
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(this.l));
            int i = this.p;
            int i2 = this.q;
            int i3 = this.n;
            uCropActivity.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uriFromFile).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropActivity.M.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", this.o).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            uCropActivity.finish();
        }
    }
}
