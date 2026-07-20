package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.UCropActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ag extends AsyncTask {
    public final Context a;
    public Uri b;
    public final Uri c;
    public final int d;
    public final int e;
    public final tb0 f;

    public ag(Context context, Uri uri, Uri uri2, int i, int i2, tb0 tb0Var) {
        this.a = context;
        this.b = uri;
        this.c = uri2;
        this.d = i;
        this.e = i2;
        this.f = tb0Var;
    }

    public final void a(Uri uri, Uri uri2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Uri uri3 = this.c;
        Log.d("BitmapWorkerTask", "copyFile");
        if (uri2 == null) {
            zy.r("Output Uri is null - cannot copy image");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            inputStreamOpenInputStream = this.a.getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                try {
                    if (inputStreamOpenInputStream == null) {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i <= 0) {
                            i1.i(fileOutputStream2);
                            i1.i(inputStreamOpenInputStream);
                            this.b = uri3;
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    i1.i(fileOutputStream);
                    i1.i(inputStreamOpenInputStream);
                    this.b = uri3;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.net.Uri r8, android.net.Uri r9) throws java.lang.Throwable {
        /*
            r7 = this;
            android.net.Uri r0 = r7.c
            java.lang.String r1 = "BitmapWorkerTask"
            java.lang.String r2 = "downloadFile"
            android.util.Log.d(r1, r2)
            if (r9 == 0) goto L94
            sn0 r1 = new sn0
            r1.<init>()
            g7 r2 = r1.b
            r3 = 0
            g7 r4 = new g7     // Catch: java.lang.Throwable -> L79
            r5 = 11
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L79
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L79
            r4.w(r8)     // Catch: java.lang.Throwable -> L79
            mv0 r8 = r4.c()     // Catch: java.lang.Throwable -> L79
            ht0 r4 = new ht0     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r1, r8)     // Catch: java.lang.Throwable -> L7f
            c70 r8 = r1.g     // Catch: java.lang.Throwable -> L7f
            r8.getClass()     // Catch: java.lang.Throwable -> L7f
            c70 r8 = defpackage.c70.g     // Catch: java.lang.Throwable -> L7f
            r4.e = r8     // Catch: java.lang.Throwable -> L7f
            hw0 r8 = r4.b()     // Catch: java.lang.Throwable -> L79
            kt0 r1 = r8.h     // Catch: java.lang.Throwable -> L76
            oh r4 = r1.g()     // Catch: java.lang.Throwable -> L76
            android.content.Context r5 = r7.a     // Catch: java.lang.Throwable -> L74
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L74
            java.io.OutputStream r9 = r5.openOutputStream(r9)     // Catch: java.lang.Throwable -> L74
            if (r9 == 0) goto L6c
            a61 r5 = new a61     // Catch: java.lang.Throwable -> L74
            r5.<init>()     // Catch: java.lang.Throwable -> L74
            java.util.logging.Logger r6 = defpackage.tn0.a     // Catch: java.lang.Throwable -> L74
            sb r6 = new sb     // Catch: java.lang.Throwable -> L74
            r6.<init>(r5, r9)     // Catch: java.lang.Throwable -> L74
            r4.k(r6)     // Catch: java.lang.Throwable -> L67
            defpackage.i1.i(r4)
            defpackage.i1.i(r6)
            defpackage.i1.i(r1)
            r2.d()
            r7.b = r0
            return
        L67:
            r9 = move-exception
        L68:
            r3 = r4
            goto L81
        L6a:
            r6 = r3
            goto L68
        L6c:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "OutputStream for given output Uri is null"
            r9.<init>(r1)     // Catch: java.lang.Throwable -> L74
            throw r9     // Catch: java.lang.Throwable -> L74
        L74:
            r9 = move-exception
            goto L6a
        L76:
            r9 = move-exception
            r6 = r3
            goto L81
        L79:
            r9 = move-exception
        L7a:
            r8 = r3
            r6 = r8
            goto L81
        L7d:
            r9 = r8
            goto L7a
        L7f:
            r8 = move-exception
            goto L7d
        L81:
            defpackage.i1.i(r3)
            defpackage.i1.i(r6)
            if (r8 == 0) goto L8e
            kt0 r8 = r8.h
            defpackage.i1.i(r8)
        L8e:
            r2.d()
            r7.b = r0
            throw r9
        L94:
            java.lang.String r7 = "Output Uri is null - cannot download image"
            defpackage.zy.r(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ag.b(android.net.Uri, android.net.Uri):void");
    }

    public final void c() {
        String scheme = this.b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        boolean zEquals = "http".equals(scheme);
        Uri uri = this.c;
        if (zEquals || "https".equals(scheme)) {
            try {
                b(this.b, uri);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e("BitmapWorkerTask", "Downloading failed", e);
                throw e;
            }
        }
        if ("content".equals(scheme)) {
            try {
                a(this.b, uri);
                return;
            } catch (IOException | NullPointerException e2) {
                Log.e("BitmapWorkerTask", "Copying failed", e2);
                throw e2;
            }
        }
        if ("file".equals(scheme)) {
            return;
        }
        Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
        zy.h("Invalid Uri scheme", scheme);
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        int i;
        int iA;
        int i2;
        InputStream inputStreamOpenInputStream;
        if (this.b == null) {
            return new zf(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            c();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            int i5 = this.d;
            int i6 = this.e;
            if (i3 > i6 || i4 > i5) {
                i = 1;
                while (true) {
                    if (i3 / i <= i6 && i4 / i <= i5) {
                        break;
                    }
                    i *= 2;
                }
            } else {
                i = 1;
            }
            options.inSampleSize = i;
            int i7 = 0;
            options.inJustDecodeBounds = false;
            boolean z = false;
            Bitmap bitmapDecodeStream = null;
            while (true) {
                Context context = this.a;
                int i8 = -1;
                if (z) {
                    Uri uri = this.b;
                    if (bitmapDecodeStream == null) {
                        return new zf(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + uri + "]"));
                    }
                    try {
                        inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        if (inputStreamOpenInputStream == null) {
                            iA = 0;
                        } else {
                            iA = new ra0(inputStreamOpenInputStream).a();
                            try {
                            } catch (IOException e) {
                                e = e;
                                Log.e("BitmapLoadUtils", "getExifOrientation: " + uri.toString(), e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        iA = 0;
                    }
                    switch (iA) {
                        case 3:
                        case 4:
                            i2 = 180;
                            break;
                        case 5:
                        case 6:
                            i2 = 90;
                            break;
                        case 7:
                        case 8:
                            i2 = 270;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    if (iA != 2 && iA != 7 && iA != 4 && iA != 5) {
                        i8 = 1;
                    }
                    xz xzVar = new xz();
                    xzVar.a = iA;
                    xzVar.b = i2;
                    xzVar.c = i8;
                    Matrix matrix = new Matrix();
                    if (i2 != 0) {
                        matrix.preRotate(i2);
                    }
                    if (i8 != 1) {
                        matrix.postScale(i8, 1.0f);
                    }
                    if (matrix.isIdentity()) {
                        return new zf(bitmapDecodeStream, xzVar);
                    }
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                        if (!bitmapDecodeStream.sameAs(bitmapCreateBitmap)) {
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                    } catch (OutOfMemoryError e3) {
                        Log.e("BitmapLoadUtils", "transformBitmap: ", e3);
                    }
                    return new zf(bitmapDecodeStream, xzVar);
                }
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(this.b);
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    } finally {
                        i1.i(inputStreamOpenInputStream);
                    }
                } catch (IOException e4) {
                    Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e4);
                    return new zf(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.b + "]", e4));
                } catch (OutOfMemoryError e5) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e5);
                    options.inSampleSize *= 2;
                    i7 = 0;
                }
                if (options.outWidth == -1 || options.outHeight == -1) {
                    zf zfVar = new zf(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.b + "]"));
                    i1.i(inputStreamOpenInputStream);
                    return zfVar;
                }
                if ((bitmapDecodeStream != null ? bitmapDecodeStream.getByteCount() : i7) > 104857600) {
                    options.inSampleSize *= 2;
                } else {
                    z = true;
                }
            }
        } catch (IOException | NullPointerException e6) {
            return new zf(e6);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        zf zfVar = (zf) obj;
        Exception exc = zfVar.c;
        tb0 tb0Var = this.f;
        if (exc != null) {
            tb0Var.getClass();
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            p81 p81Var = ((q81) tb0Var.c).k;
            if (p81Var != null) {
                UCropActivity uCropActivity = ((wc1) p81Var).b;
                uCropActivity.F(exc);
                uCropActivity.finish();
                return;
            }
            return;
        }
        Bitmap bitmap = zfVar.a;
        xz xzVar = zfVar.b;
        String path = this.b.getPath();
        Uri uri = this.c;
        String path2 = uri == null ? null : uri.getPath();
        q81 q81Var = (q81) tb0Var.c;
        q81Var.q = path;
        q81Var.r = path2;
        q81Var.s = xzVar;
        q81Var.n = true;
        q81Var.setImageBitmap(bitmap);
    }
}
