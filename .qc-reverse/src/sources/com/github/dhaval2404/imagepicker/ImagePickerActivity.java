package com.github.dhaval2404.imagepicker;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.quickcursor.R;
import com.yalantis.ucrop.UCropActivity;
import defpackage.e31;
import defpackage.fc0;
import defpackage.fp1;
import defpackage.i1;
import defpackage.ji;
import defpackage.k50;
import defpackage.rm;
import defpackage.sm;
import defpackage.ta0;
import defpackage.uq;
import defpackage.xy0;
import defpackage.z7;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ImagePickerActivity extends z7 {
    public k50 A;
    public ji B;
    public uq C;
    public sm D;

    public final void E(Uri uri) {
        int i;
        uq uqVar = this.C;
        if (uqVar == null) {
            fc0.S("mCropProvider");
            throw null;
        }
        ImagePickerActivity imagePickerActivity = uqVar.a;
        if (!uqVar.d) {
            sm smVar = this.D;
            if (smVar == null) {
                fc0.S("mCompressionProvider");
                throw null;
            }
            if (!smVar.e(uri)) {
                F(uri);
                return;
            }
            sm smVar2 = this.D;
            if (smVar2 != null) {
                new rm(smVar2).execute(uri);
                return;
            } else {
                fc0.S("mCompressionProvider");
                throw null;
            }
        }
        String strV = i1.v(uri);
        File fileW = i1.w(uqVar.h, strV);
        uqVar.g = fileW;
        if (fileW == null || !fileW.exists()) {
            Log.e("uq", "Failed to create crop image file");
            uqVar.c(R.string.error_failed_to_crop_image);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("com.yalantis.ucrop.CompressionFormatName", (e31.b0(strV, "png", true) ? Bitmap.CompressFormat.PNG : e31.b0(strV, "webp", true) ? Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG).name());
        Uri uriFromFile = Uri.fromFile(uqVar.g);
        Intent intent = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.yalantis.ucrop.InputUri", uri);
        bundle2.putParcelable("com.yalantis.ucrop.OutputUri", uriFromFile);
        bundle2.putAll(bundle);
        float f = uqVar.e;
        if (f > 0.0f) {
            float f2 = uqVar.f;
            if (f2 > 0.0f) {
                bundle2.putFloat("com.yalantis.ucrop.AspectRatioX", f);
                bundle2.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
            }
        }
        int i2 = uqVar.b;
        if (i2 > 0 && (i = uqVar.c) > 0) {
            if (i2 < 10) {
                i2 = 10;
            }
            if (i < 10) {
                i = 10;
            }
            bundle2.putInt("com.yalantis.ucrop.MaxSizeX", i2);
            bundle2.putInt("com.yalantis.ucrop.MaxSizeY", i);
        }
        try {
            intent.setClass(imagePickerActivity, UCropActivity.class);
            intent.putExtras(bundle2);
            imagePickerActivity.startActivityForResult(intent, 69);
        } catch (ActivityNotFoundException e) {
            uqVar.b();
            imagePickerActivity.getClass();
            Intent intent2 = new Intent();
            intent2.putExtra("extra.error", "uCrop not specified in manifest file.Add UCropActivity in Manifest<activity\n    android:name=\"com.yalantis.ucrop.UCropActivity\"\n    android:screenOrientation=\"portrait\"\n    android:theme=\"@style/Theme.AppCompat.Light.NoActionBar\"/>");
            imagePickerActivity.setResult(64, intent2);
            imagePickerActivity.finish();
            e.printStackTrace();
        }
    }

    public final void F(Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        intent.putExtra("extra.file_path", fp1.k(this, uri));
        setResult(-1, intent);
        finish();
    }

    @Override // defpackage.z7, defpackage.pm, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ji jiVar = this.B;
        if (jiVar != null) {
            ImagePickerActivity imagePickerActivity = jiVar.a;
            if (i == 4281) {
                if (i2 == -1) {
                    Uri uriFromFile = Uri.fromFile(jiVar.b);
                    uriFromFile.getClass();
                    imagePickerActivity.E(uriFromFile);
                } else {
                    jiVar.b();
                    imagePickerActivity.getClass();
                    Intent intent2 = new Intent();
                    String string = imagePickerActivity.getString(R.string.error_task_cancelled);
                    string.getClass();
                    intent2.putExtra("extra.error", string);
                    imagePickerActivity.setResult(0, intent2);
                    imagePickerActivity.finish();
                }
            }
        }
        k50 k50Var = this.A;
        if (k50Var != null) {
            ImagePickerActivity imagePickerActivity2 = k50Var.a;
            if (i == 4261) {
                if (i2 == -1) {
                    Uri data = intent != null ? intent.getData() : null;
                    if (data != null) {
                        k50Var.getContentResolver().takePersistableUriPermission(data, 1);
                        imagePickerActivity2.E(data);
                    } else {
                        k50Var.c(R.string.error_failed_pick_gallery_image);
                    }
                } else {
                    imagePickerActivity2.getClass();
                    Intent intent3 = new Intent();
                    String string2 = imagePickerActivity2.getString(R.string.error_task_cancelled);
                    string2.getClass();
                    intent3.putExtra("extra.error", string2);
                    imagePickerActivity2.setResult(0, intent3);
                    imagePickerActivity2.finish();
                }
            }
        }
        uq uqVar = this.C;
        if (uqVar == null) {
            fc0.S("mCropProvider");
            throw null;
        }
        ImagePickerActivity imagePickerActivity3 = uqVar.a;
        if (i == 69) {
            if (i2 != -1) {
                uqVar.b();
                imagePickerActivity3.getClass();
                Intent intent4 = new Intent();
                String string3 = imagePickerActivity3.getString(R.string.error_task_cancelled);
                string3.getClass();
                intent4.putExtra("extra.error", string3);
                imagePickerActivity3.setResult(0, intent4);
                imagePickerActivity3.finish();
                return;
            }
            File file = uqVar.g;
            if (file == null) {
                uqVar.c(R.string.error_failed_to_crop_image);
                return;
            }
            Uri uriFromFile2 = Uri.fromFile(file);
            uriFromFile2.getClass();
            imagePickerActivity3.getClass();
            ji jiVar2 = imagePickerActivity3.B;
            if (jiVar2 != null) {
                File file2 = jiVar2.b;
                if (file2 != null) {
                    file2.delete();
                }
                jiVar2.b = null;
            }
            sm smVar = imagePickerActivity3.D;
            if (smVar == null) {
                fc0.S("mCompressionProvider");
                throw null;
            }
            if (!smVar.e(uriFromFile2)) {
                imagePickerActivity3.F(uriFromFile2);
                return;
            }
            sm smVar2 = imagePickerActivity3.D;
            if (smVar2 != null) {
                new rm(smVar2).execute(uriFromFile2);
            } else {
                fc0.S("mCompressionProvider");
                throw null;
            }
        }
    }

    @Override // defpackage.pm, android.app.Activity
    public final void onBackPressed() {
        Intent intent = new Intent();
        String string = getString(R.string.error_task_cancelled);
        string.getClass();
        intent.putExtra("extra.error", string);
        setResult(0, intent);
        finish();
    }

    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        ji jiVar;
        super.onCreate(bundle);
        uq uqVar = new uq(this);
        this.C = uqVar;
        uqVar.g = (File) (bundle != null ? bundle.getSerializable("state.crop_file") : null);
        this.D = new sm(this);
        Intent intent = getIntent();
        ta0 ta0Var = (ta0) (intent != null ? intent.getSerializableExtra("extra.image_provider") : null);
        if (ta0Var != null) {
            int iOrdinal = ta0Var.ordinal();
            if (iOrdinal == 0) {
                k50 k50Var = new k50(this);
                this.A = k50Var;
                if (bundle != null) {
                    return;
                }
                ImagePickerActivity imagePickerActivity = k50Var.a;
                imagePickerActivity.getClass();
                String[] strArr = k50Var.b;
                strArr.getClass();
                Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent2.setType("image/*");
                if (strArr.length != 0) {
                    intent2.putExtra("android.intent.extra.MIME_TYPES", strArr);
                }
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.addFlags(64);
                intent2.addFlags(1);
                intent2.addFlags(2);
                if (intent2.resolveActivity(imagePickerActivity.getPackageManager()) == null) {
                    intent2 = new Intent("android.intent.action.PICK");
                    intent2.setType("image/*");
                    if (strArr.length != 0) {
                        intent2.putExtra("android.intent.extra.MIME_TYPES", strArr);
                    }
                }
                imagePickerActivity.startActivityForResult(intent2, 4261);
                return;
            }
            if (iOrdinal == 1) {
                ji jiVar2 = new ji(this);
                this.B = jiVar2;
                jiVar2.b = (File) (bundle != null ? bundle.getSerializable("state.camera_file") : null);
                if (bundle == null && (jiVar = this.B) != null) {
                    jiVar.e();
                    return;
                }
                return;
            }
        }
        Log.e("image_picker", "Image provider can not be null");
        String string = getString(R.string.error_task_cancelled);
        string.getClass();
        Intent intent3 = new Intent();
        intent3.putExtra("extra.error", string);
        setResult(64, intent3);
        finish();
    }

    @Override // defpackage.z7, defpackage.pm, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        super.onRequestPermissionsResult(i, strArr, iArr);
        ji jiVar = this.B;
        if (jiVar == null || i != 4282) {
            return;
        }
        for (String str : ji.d(jiVar)) {
            str.getClass();
            if (xy0.f(jiVar, str) != 0) {
                String string = jiVar.getString(R.string.permission_camera_denied);
                string.getClass();
                jiVar.b();
                ImagePickerActivity imagePickerActivity = jiVar.a;
                imagePickerActivity.getClass();
                Intent intent = new Intent();
                intent.putExtra("extra.error", string);
                imagePickerActivity.setResult(64, intent);
                imagePickerActivity.finish();
                return;
            }
        }
        jiVar.e();
    }

    @Override // defpackage.pm, defpackage.om, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        ji jiVar = this.B;
        if (jiVar != null) {
            bundle.putSerializable("state.camera_file", jiVar.b);
        }
        uq uqVar = this.C;
        if (uqVar == null) {
            fc0.S("mCropProvider");
            throw null;
        }
        bundle.putSerializable("state.crop_file", uqVar.g);
        super.onSaveInstanceState(bundle);
    }
}
