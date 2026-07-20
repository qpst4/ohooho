package defpackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sm extends le {
    public final int b;
    public final int c;
    public final long d;
    public final File e;

    public sm(ImagePickerActivity imagePickerActivity) {
        super(imagePickerActivity);
        Intent intent = imagePickerActivity.getIntent();
        intent.getClass();
        Bundle extras = intent.getExtras();
        extras = extras == null ? new Bundle() : extras;
        this.b = extras.getInt("extra.max_width", 0);
        this.c = extras.getInt("extra.max_height", 0);
        this.d = extras.getLong("extra.image_max_size", 0L);
        this.e = a(extras.getString("extra.save_directory"));
    }

    public final File d(File file, int i) {
        FileOutputStream fileOutputStream;
        int i2;
        List listK0 = kl.K0(new int[]{2448, 3264}, new int[]{2008, 3032}, new int[]{1944, 2580}, new int[]{1680, 2240}, new int[]{1536, 2048}, new int[]{1200, 1600}, new int[]{1024, 1392}, new int[]{960, 1280}, new int[]{768, 1024}, new int[]{600, 800}, new int[]{480, 640}, new int[]{240, 320}, new int[]{120, 160}, new int[]{60, 80}, new int[]{30, 40});
        FileOutputStream fileOutputStream2 = null;
        if (i < listK0.size()) {
            int[] iArr = (int[]) listK0.get(i);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = this.b;
            if (i5 > 0 && (i2 = this.c) > 0 && (i3 > i5 || i4 > i2)) {
                i3 = i5;
                i4 = i2;
            }
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            if (absolutePath.endsWith(".png")) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            Uri uriFromFile = Uri.fromFile(file);
            uriFromFile.getClass();
            File fileW = i1.w(this.e, i1.v(uriFromFile));
            if (fileW != null) {
                float f = i3;
                float f2 = i4;
                String absolutePath2 = fileW.getAbsolutePath();
                absolutePath2.getClass();
                compressFormat.getClass();
                File parentFile = new File(absolutePath2).getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    fileOutputStream = new FileOutputStream(absolutePath2);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Bitmap bitmapQ = lc1.q(file, f, f2);
                    if (bitmapQ != null) {
                        bitmapQ.compress(compressFormat, 100, fileOutputStream);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return new File(absolutePath2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.net.Uri r11) throws java.lang.Throwable {
        /*
            r10 = this;
            long r0 = r10.d
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            r6 = 0
            r7 = 1
            if (r4 <= 0) goto L44
            java.lang.String r4 = "file"
            java.lang.String r8 = r11.getScheme()
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 == 0) goto L2c
            java.lang.String r4 = defpackage.fp1.k(r10, r11)
            if (r4 == 0) goto L2a
            java.io.File r8 = new java.io.File
            r8.<init>(r4)
            et0 r4 = new et0
            r4.<init>()
            r4.m = r8
            goto L35
        L2a:
            r4 = r6
            goto L35
        L2c:
            b11 r4 = new b11
            r4.<init>()
            r4.m = r10
            r4.n = r11
        L35:
            if (r4 == 0) goto L3c
            long r8 = r4.D()
            goto L3d
        L3c:
            r8 = r2
        L3d:
            long r8 = r8 - r0
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 <= 0) goto L44
            r0 = r7
            goto L45
        L44:
            r0 = r5
        L45:
            if (r0 != 0) goto L7c
            int r1 = r10.b
            if (r1 <= 0) goto L7c
            int r2 = r10.c
            if (r2 <= 0) goto L7c
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inJustDecodeBounds = r7
            android.content.ContentResolver r10 = r10.getContentResolver()
            java.io.InputStream r10 = r10.openInputStream(r11)
            android.graphics.BitmapFactory.decodeStream(r10, r6, r0)
            int r10 = r0.outWidth
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r11 = r0.outHeight
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r10 = r10.intValue()
            if (r10 > r1) goto L7b
            int r10 = r11.intValue()
            if (r10 <= r2) goto L7a
            goto L7b
        L7a:
            return r5
        L7b:
            return r7
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sm.e(android.net.Uri):boolean");
    }
}
