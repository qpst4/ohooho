package com.canhub.cropper;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.canhub.cropper.CropImageActivity;
import com.canhub.cropper.CropImageView;
import com.quickcursor.R;
import defpackage.cq;
import defpackage.e31;
import defpackage.e4;
import defpackage.f4;
import defpackage.fc0;
import defpackage.gq;
import defpackage.i9;
import defpackage.k4;
import defpackage.kl;
import defpackage.kq;
import defpackage.vp;
import defpackage.yb0;
import defpackage.z7;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CropImageActivity extends z7 implements kq, gq {
    public static final /* synthetic */ int H = 0;
    public Uri A;
    public cq B;
    public CropImageView C;
    public i9 D;
    public Uri E;
    public final k4 F;
    public final k4 G;

    public CropImageActivity() {
        final int i = 0;
        this.F = (k4) t(new e4(this) { // from class: wp
            public final /* synthetic */ CropImageActivity c;

            {
                this.c = this;
            }

            @Override // defpackage.e4
            public final void b(Object obj) {
                int i2 = i;
                CropImageActivity cropImageActivity = this.c;
                switch (i2) {
                    case 0:
                        Uri uri = (Uri) obj;
                        int i3 = CropImageActivity.H;
                        if (uri != null) {
                            cropImageActivity.A = uri;
                            CropImageView cropImageView = cropImageActivity.C;
                            if (cropImageView != null) {
                                cropImageView.setImageUriAsync(uri);
                            }
                        } else {
                            cropImageActivity.G();
                        }
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i4 = CropImageActivity.H;
                        if (!zBooleanValue) {
                            cropImageActivity.G();
                        } else {
                            Uri uri2 = cropImageActivity.E;
                            if (uri2 != null) {
                                cropImageActivity.A = uri2;
                                CropImageView cropImageView2 = cropImageActivity.C;
                                if (cropImageView2 != null) {
                                    cropImageView2.setImageUriAsync(uri2);
                                }
                            } else {
                                cropImageActivity.G();
                            }
                        }
                        break;
                }
            }
        }, new f4(0));
        final int i2 = 1;
        this.G = (k4) t(new e4(this) { // from class: wp
            public final /* synthetic */ CropImageActivity c;

            {
                this.c = this;
            }

            @Override // defpackage.e4
            public final void b(Object obj) {
                int i22 = i2;
                CropImageActivity cropImageActivity = this.c;
                switch (i22) {
                    case 0:
                        Uri uri = (Uri) obj;
                        int i3 = CropImageActivity.H;
                        if (uri != null) {
                            cropImageActivity.A = uri;
                            CropImageView cropImageView = cropImageActivity.C;
                            if (cropImageView != null) {
                                cropImageView.setImageUriAsync(uri);
                            }
                        } else {
                            cropImageActivity.G();
                        }
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i4 = CropImageActivity.H;
                        if (!zBooleanValue) {
                            cropImageActivity.G();
                        } else {
                            Uri uri2 = cropImageActivity.E;
                            if (uri2 != null) {
                                cropImageActivity.A = uri2;
                                CropImageView cropImageView2 = cropImageActivity.C;
                                if (cropImageView2 != null) {
                                    cropImageView2.setImageUriAsync(uri2);
                                }
                            } else {
                                cropImageActivity.G();
                            }
                        }
                        break;
                }
            }
        }, new f4(4));
    }

    public static void H(Menu menu, int i, int i2) {
        Drawable icon;
        MenuItem menuItemFindItem = menu.findItem(i);
        if (menuItemFindItem == null || (icon = menuItemFindItem.getIcon()) == null) {
            return;
        }
        try {
            icon.mutate();
            icon.setColorFilter(yb0.e(i2));
            menuItemFindItem.setIcon(icon);
        } catch (Exception e) {
            Log.w("AIC", "Failed to update menu item color", e);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final void E() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageActivity.E():void");
    }

    public final void F(Uri uri, Exception exc, int i) {
        int i2 = exc != null ? 204 : -1;
        CropImageView cropImageView = this.C;
        Uri imageUri = cropImageView != null ? cropImageView.getImageUri() : null;
        CropImageView cropImageView2 = this.C;
        float[] cropPoints = cropImageView2 != null ? cropImageView2.getCropPoints() : null;
        CropImageView cropImageView3 = this.C;
        Rect cropRect = cropImageView3 != null ? cropImageView3.getCropRect() : null;
        CropImageView cropImageView4 = this.C;
        int rotatedDegrees = cropImageView4 != null ? cropImageView4.getRotatedDegrees() : 0;
        CropImageView cropImageView5 = this.C;
        Rect wholeImageRect = cropImageView5 != null ? cropImageView5.getWholeImageRect() : null;
        cropPoints.getClass();
        vp vpVar = new vp(imageUri, uri, exc, cropPoints, cropRect, wholeImageRect, rotatedDegrees, i);
        Intent intent = new Intent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", vpVar);
        setResult(i2, intent);
        finish();
    }

    public final void G() {
        setResult(0);
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0216  */
    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r53) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 936
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        Drawable drawable;
        CharSequence title;
        cq cqVar;
        menu.getClass();
        cq cqVar2 = this.B;
        if (cqVar2 == null) {
            fc0.S("cropImageOptions");
            throw null;
        }
        if (!cqVar2.h0) {
            getMenuInflater().inflate(R.menu.crop_image_menu, menu);
            cq cqVar3 = this.B;
            if (cqVar3 == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            if (!cqVar3.Z) {
                menu.removeItem(R.id.ic_rotate_left_24);
                menu.removeItem(R.id.ic_rotate_right_24);
            } else if (cqVar3.b0) {
                menu.findItem(R.id.ic_rotate_left_24).setVisible(true);
            }
            cq cqVar4 = this.B;
            if (cqVar4 == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            if (!cqVar4.a0) {
                menu.removeItem(R.id.ic_flip_24);
            }
            cq cqVar5 = this.B;
            if (cqVar5 == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            if (cqVar5.f0 != null) {
                MenuItem menuItemFindItem = menu.findItem(R.id.crop_image_menu_crop);
                cq cqVar6 = this.B;
                if (cqVar6 == null) {
                    fc0.S("cropImageOptions");
                    throw null;
                }
                menuItemFindItem.setTitle(cqVar6.f0);
            }
            try {
                cqVar = this.B;
            } catch (Exception e) {
                e = e;
                drawable = null;
            }
            if (cqVar == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            int i = cqVar.g0;
            if (i != 0) {
                drawable = getDrawable(i);
                try {
                    menu.findItem(R.id.crop_image_menu_crop).setIcon(drawable);
                } catch (Exception e2) {
                    e = e2;
                    Log.w("AIC", "Failed to read menu crop drawable", e);
                }
            } else {
                drawable = null;
            }
            cq cqVar7 = this.B;
            if (cqVar7 == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            int i2 = cqVar7.O;
            if (i2 != 0) {
                H(menu, R.id.ic_rotate_left_24, i2);
                cq cqVar8 = this.B;
                if (cqVar8 == null) {
                    fc0.S("cropImageOptions");
                    throw null;
                }
                H(menu, R.id.ic_rotate_right_24, cqVar8.O);
                cq cqVar9 = this.B;
                if (cqVar9 == null) {
                    fc0.S("cropImageOptions");
                    throw null;
                }
                H(menu, R.id.ic_flip_24, cqVar9.O);
                if (drawable != null) {
                    cq cqVar10 = this.B;
                    if (cqVar10 == null) {
                        fc0.S("cropImageOptions");
                        throw null;
                    }
                    H(menu, R.id.crop_image_menu_crop, cqVar10.O);
                }
            }
            cq cqVar11 = this.B;
            if (cqVar11 == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            Integer num = cqVar11.P;
            if (num != null) {
                int iIntValue = num.intValue();
                Iterator it = kl.K0(Integer.valueOf(R.id.ic_rotate_left_24), Integer.valueOf(R.id.ic_rotate_right_24), Integer.valueOf(R.id.ic_flip_24), Integer.valueOf(R.id.ic_flip_24_horizontally), Integer.valueOf(R.id.ic_flip_24_vertically), Integer.valueOf(R.id.crop_image_menu_crop)).iterator();
                while (it.hasNext()) {
                    MenuItem menuItemFindItem2 = menu.findItem(((Number) it.next()).intValue());
                    if (menuItemFindItem2 != null && (title = menuItemFindItem2.getTitle()) != null && (!e31.d0(title))) {
                        try {
                            SpannableString spannableString = new SpannableString(title);
                            spannableString.setSpan(new ForegroundColorSpan(iIntValue), 0, spannableString.length(), 33);
                            menuItemFindItem2.setTitle(spannableString);
                        } catch (Exception e3) {
                            Log.w("AIC", "Failed to update menu item color", e3);
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, InvocationTargetException {
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        if (itemId == R.id.crop_image_menu_crop) {
            E();
            return true;
        }
        if (itemId == R.id.ic_rotate_left_24) {
            cq cqVar = this.B;
            if (cqVar == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            int i = -cqVar.c0;
            CropImageView cropImageView = this.C;
            if (cropImageView != null) {
                cropImageView.e(i);
                return true;
            }
        } else if (itemId == R.id.ic_rotate_right_24) {
            cq cqVar2 = this.B;
            if (cqVar2 == null) {
                fc0.S("cropImageOptions");
                throw null;
            }
            int i2 = cqVar2.c0;
            CropImageView cropImageView2 = this.C;
            if (cropImageView2 != null) {
                cropImageView2.e(i2);
                return true;
            }
        } else if (itemId == R.id.ic_flip_24_horizontally) {
            CropImageView cropImageView3 = this.C;
            if (cropImageView3 != null) {
                cropImageView3.m = !cropImageView3.m;
                cropImageView3.a(cropImageView3.getWidth(), cropImageView3.getHeight(), true, false);
                return true;
            }
        } else {
            if (itemId != R.id.ic_flip_24_vertically) {
                if (itemId != 16908332) {
                    return super.onOptionsItemSelected(menuItem);
                }
                G();
                return true;
            }
            CropImageView cropImageView4 = this.C;
            if (cropImageView4 != null) {
                cropImageView4.n = !cropImageView4.n;
                cropImageView4.a(cropImageView4.getWidth(), cropImageView4.getHeight(), true, false);
            }
        }
        return true;
    }

    @Override // defpackage.pm, defpackage.om, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        bundle.putString("bundle_key_tmp_uri", String.valueOf(this.E));
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onStart() {
        super.onStart();
        CropImageView cropImageView = this.C;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(this);
        }
        CropImageView cropImageView2 = this.C;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(this);
        }
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onStop() {
        super.onStop();
        CropImageView cropImageView = this.C;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(null);
        }
        CropImageView cropImageView2 = this.C;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(null);
        }
    }
}
