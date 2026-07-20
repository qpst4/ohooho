package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.provider.MediaStore;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.canhub.cropper.CropImageActivity;
import com.quickcursor.R;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.crypto.KeyGenerator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class h7 implements z00 {
    public final Object b;
    public Object c;
    public Object d;
    public Object e;
    public final Object f;

    public h7(g7 g7Var) throws GeneralSecurityException, IOException {
        tb0 tb0Var;
        pn0 pn0Var = (pn0) g7Var.c;
        this.b = pn0Var;
        if (pn0Var == null) {
            zy.n("need to specify where to read the keyset from with Builder#withSharedPref");
            throw null;
        }
        pn0 pn0Var2 = (pn0) g7Var.d;
        this.c = pn0Var2;
        if (pn0Var2 == null) {
            zy.n("need to specify where to write the keyset to with Builder#withSharedPref");
            throw null;
        }
        String str = (String) g7Var.b;
        if (str == null) {
            zy.n("need a master key URI, please set it with Builder#masterKeyUri");
            throw null;
        }
        String strB = ee1.b(str);
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        boolean zContainsAlias = keyStore.containsAlias(strB);
        int i = 3;
        if (!zContainsAlias) {
            String strB2 = ee1.b(str);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(strB2, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            keyGenerator.generateKey();
        }
        try {
            this.d = new a5(ee1.b(str));
            this.e = (je0) g7Var.e;
            try {
                tb0Var = b();
            } catch (IOException e) {
                Log.i("h7", "cannot read keyset: " + e.toString());
                if (((je0) this.e) == null) {
                    s1.l("cannot obtain keyset handle");
                    throw null;
                }
                pe0 pe0Var = (pe0) se0.f.k();
                tb0Var = new tb0(i, pe0Var);
                je0 je0Var = (je0) this.e;
                synchronized (tb0Var) {
                    re0 re0VarH = tb0Var.h(je0Var);
                    pe0Var.c();
                    se0 se0Var = (se0) pe0Var.c;
                    se0Var.getClass();
                    sr0 sr0Var = se0Var.e;
                    if (!sr0Var.b) {
                        se0Var.e = w50.h(sr0Var);
                    }
                    se0Var.e.add(re0VarH);
                    int i2 = re0VarH.f;
                    pe0Var.c();
                    ((se0) pe0Var.c).d = i2;
                    try {
                        tb0Var.g().l((pn0) this.c, (a5) this.d);
                    } catch (IOException e2) {
                        throw new GeneralSecurityException(e2);
                    }
                }
            }
            this.f = tb0Var;
        } catch (IOException e3) {
            throw new GeneralSecurityException(e3);
        }
    }

    public ArrayList a(PackageManager packageManager, String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        Intent intent = str.equals("android.intent.action.GET_CONTENT") ? new Intent(str) : new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intent, 0);
        listQueryIntentActivities.getClass();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : (List) this.d) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (fc0.b(((Intent) obj).getPackage(), str2)) {
                    break;
                }
            }
            Intent intent3 = (Intent) obj;
            if (intent3 != null) {
                arrayList.remove(intent3);
                arrayList2.add(intent3);
            }
        }
        arrayList.addAll(0, arrayList2);
        return arrayList;
    }

    public tb0 b() throws GeneralSecurityException, IOException {
        a5 a5Var = (a5) this.d;
        pn0 pn0Var = (pn0) this.b;
        int i = 3;
        try {
            return new tb0(i, (pe0) ((se0) tb0.k(pn0Var, a5Var).c).k());
        } catch (ic0 | GeneralSecurityException e) {
            Log.i("h7", "cannot decrypt keyset: " + e.toString());
            byte[] bArrI = pn0Var.I();
            se0 se0Var = se0.f;
            w00 w00VarA = w00.a();
            int length = bArrI.length;
            cl clVar = new cl(bArrI, 0, length, false);
            try {
                if (length < 0) {
                    throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                int i2 = clVar.f + length;
                if (i2 > Integer.MAX_VALUE) {
                    throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                clVar.g = i2;
                clVar.j();
                w50 w50VarJ = w50.j(se0Var, clVar, w00VarA);
                clVar.a(0);
                w50.a(w50VarJ);
                se0 se0Var2 = (se0) w50VarJ;
                if (se0Var2.e.c.size() > 0) {
                    new tb0(2, se0Var2).l((pn0) this.c, a5Var);
                    return new tb0(i, (pe0) se0Var2.k());
                }
                s1.l("empty keyset");
                return null;
            } catch (ic0 e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    @Override // defpackage.wr0
    public Object get() {
        return new ss((Executor) ((wr0) this.b).get(), (tl0) ((wr0) this.c).get(), (ra) ((ra) this.d).get(), (dx0) ((wr0) this.e).get(), (dx0) ((wr0) this.f).get());
    }

    public h7(wr0 wr0Var, wr0 wr0Var2, ra raVar, wr0 wr0Var3, wr0 wr0Var4) {
        this.b = wr0Var;
        this.c = wr0Var2;
        this.d = raVar;
        this.e = wr0Var3;
        this.f = wr0Var4;
    }

    public h7(f71 f71Var) {
        this.b = (ij0) f71Var.b;
        this.c = (ix) f71Var.d;
        this.d = (ow0) f71Var.e;
        this.e = (ow0) f71Var.f;
        this.f = (tb0) f71Var.h;
    }

    public h7(CropImageActivity cropImageActivity, sp1 sp1Var) {
        this.b = sp1Var;
        String string = cropImageActivity.getString(R.string.pick_image_chooser_title);
        string.getClass();
        this.c = string;
        this.d = kl.K0("com.google.android.apps.photos", "com.google.android.apps.photosgo", "com.sec.android.gallery3d", "com.oneplus.gallery", "com.miui.gallery");
        this.f = (k4) cropImageActivity.t(new r1(10, this), new f4(2));
    }
}
