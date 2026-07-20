package defpackage;

import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.LocusId;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tb0 implements pj0, kr0, ni, a1, vp1 {
    public final /* synthetic */ int b;
    public Object c;

    public tb0(Context context, ShortcutInfo shortcutInfo) {
        np0[] np0VarArr;
        String string;
        this.b = 15;
        c01 c01Var = new c01();
        this.c = c01Var;
        c01Var.a = context;
        c01Var.b = shortcutInfo.getId();
        shortcutInfo.getPackage();
        Intent[] intents = shortcutInfo.getIntents();
        c01Var.c = (Intent[]) Arrays.copyOf(intents, intents.length);
        c01Var.d = shortcutInfo.getActivity();
        c01Var.e = shortcutInfo.getShortLabel();
        c01Var.f = shortcutInfo.getLongLabel();
        c01Var.g = shortcutInfo.getDisabledMessage();
        if (Build.VERSION.SDK_INT >= 28) {
            shortcutInfo.getDisabledReason();
        } else {
            shortcutInfo.isEnabled();
        }
        c01Var.j = shortcutInfo.getCategories();
        PersistableBundle extras = shortcutInfo.getExtras();
        ni0 ni0Var = null;
        if (extras == null || !extras.containsKey("extraPersonCount")) {
            np0VarArr = null;
        } else {
            int i = extras.getInt("extraPersonCount");
            np0VarArr = new np0[i];
            int i2 = 0;
            while (i2 < i) {
                StringBuilder sb = new StringBuilder("extraPerson_");
                int i3 = i2 + 1;
                sb.append(i3);
                PersistableBundle persistableBundle = extras.getPersistableBundle(sb.toString());
                String string2 = persistableBundle.getString("name");
                String string3 = persistableBundle.getString("uri");
                String string4 = persistableBundle.getString("key");
                boolean z = persistableBundle.getBoolean("isBot");
                boolean z2 = persistableBundle.getBoolean("isImportant");
                np0 np0Var = new np0();
                np0Var.a = string2;
                np0Var.b = string3;
                np0Var.c = string4;
                np0Var.d = z;
                np0Var.e = z2;
                np0VarArr[i2] = np0Var;
                i2 = i3;
            }
        }
        c01Var.i = np0VarArr;
        shortcutInfo.getUserHandle();
        shortcutInfo.getLastChangedTimestamp();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            shortcutInfo.isCached();
        }
        shortcutInfo.isDynamic();
        shortcutInfo.isPinned();
        shortcutInfo.isDeclaredInManifest();
        shortcutInfo.isImmutable();
        shortcutInfo.isEnabled();
        shortcutInfo.hasKeyFieldsOnly();
        c01 c01Var2 = (c01) this.c;
        if (i4 < 29) {
            PersistableBundle extras2 = shortcutInfo.getExtras();
            if (extras2 != null && (string = extras2.getString("extraLocusId")) != null) {
                ni0Var = new ni0(string);
            }
        } else if (shortcutInfo.getLocusId() != null) {
            LocusId locusId = shortcutInfo.getLocusId();
            f01.k("locusId cannot be null", locusId);
            String strC = ua.c(locusId);
            if (TextUtils.isEmpty(strC)) {
                zy.n("id cannot be empty");
                throw null;
            }
            ni0Var = new ni0(strC);
        }
        c01Var2.k = ni0Var;
        ((c01) this.c).l = shortcutInfo.getRank();
        ((c01) this.c).m = shortcutInfo.getExtras();
    }

    public static int j() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & 127) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i;
    }

    public static final tb0 k(pn0 pn0Var, a5 a5Var) throws GeneralSecurityException, IOException {
        byte[] bArrI = pn0Var.I();
        yy yyVar = yy.f;
        w00 w00VarA = w00.a();
        int length = bArrI.length;
        cl clVar = new cl(bArrI, 0, length, false);
        try {
            if (length < 0) {
                throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            int i = clVar.f + length;
            if (i > Integer.MAX_VALUE) {
                throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            clVar.g = i;
            clVar.j();
            w50 w50VarJ = w50.j(yyVar, clVar, w00VarA);
            clVar.a(0);
            w50.a(w50VarJ);
            yy yyVar2 = (yy) w50VarJ;
            if (yyVar2.d.size() == 0) {
                s1.l("empty keyset");
                return null;
            }
            try {
                byte[] bArrB = a5Var.b(yyVar2.d.e(), new byte[0]);
                se0 se0Var = se0.f;
                w00 w00VarA2 = w00.a();
                int length2 = bArrB.length;
                cl clVar2 = new cl(bArrB, 0, length2, false);
                try {
                    if (length2 < 0) {
                        throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                    }
                    int i2 = clVar2.f + length2;
                    if (i2 > Integer.MAX_VALUE) {
                        throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    clVar2.g = i2;
                    clVar2.j();
                    w50 w50VarJ2 = w50.j(se0Var, clVar2, w00VarA2);
                    clVar2.a(0);
                    w50.a(w50VarJ2);
                    se0 se0Var2 = (se0) w50VarJ2;
                    if (se0Var2.e.c.size() > 0) {
                        return new tb0(2, se0Var2);
                    }
                    throw new GeneralSecurityException("empty keyset");
                } catch (ic0 e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (ic0 unused) {
                s1.l("invalid keyset, corrupted key material");
                return null;
            }
        } catch (ic0 e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // defpackage.a1
    public boolean a(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.c;
        if (!swipeDismissBehavior.r(view)) {
            return false;
        }
        WeakHashMap weakHashMap = uf1.a;
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.d;
        view.offsetLeftAndRight((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    @Override // defpackage.vp1
    public cq1 b(Class cls) {
        for (int i = 0; i < 2; i++) {
            vp1 vp1Var = ((vp1[]) this.c)[i];
            if (vp1Var.d(cls)) {
                return vp1Var.b(cls);
            }
        }
        zy.f("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    public synchronized void c(uw0 uw0Var) {
        ((LinkedHashSet) this.c).remove(uw0Var);
    }

    @Override // defpackage.vp1
    public boolean d(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((vp1[]) this.c)[i].d(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.kr0
    public void e() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // defpackage.kr0
    public void f(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.c).setResultCode(i);
    }

    public synchronized tb0 g() {
        se0 se0Var;
        se0Var = (se0) ((pe0) this.c).a();
        if (se0Var.e.c.size() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new tb0(2, se0Var);
    }

    public synchronized re0 h(je0 je0Var) {
        qe0 qe0Var;
        fe0 fe0VarF = ev0.f(je0Var);
        int i = i();
        int iB = l11.b(je0Var.f);
        if (iB == 0) {
            iB = 6;
        }
        if (iB == 1) {
            iB = 2;
        }
        qe0Var = (qe0) re0.h.k();
        qe0Var.c();
        re0 re0Var = (re0) qe0Var.c;
        re0Var.getClass();
        fe0VarF.getClass();
        re0Var.d = fe0VarF;
        qe0Var.c();
        ((re0) qe0Var.c).f = i;
        qe0Var.c();
        re0 re0Var2 = (re0) qe0Var.c;
        re0Var2.getClass();
        re0Var2.e = 1;
        qe0Var.c();
        re0 re0Var3 = (re0) qe0Var.c;
        re0Var3.getClass();
        re0Var3.g = l11.f(iB);
        return (re0) qe0Var.a();
    }

    public synchronized int i() {
        int iJ;
        iJ = j();
        Iterator it = Collections.unmodifiableList(((se0) ((pe0) this.c).c).e).iterator();
        while (it.hasNext()) {
            if (((re0) it.next()).f == iJ) {
                iJ = j();
            }
        }
        return iJ;
    }

    public void l(pn0 pn0Var, a5 a5Var) throws GeneralSecurityException {
        se0 se0Var = (se0) this.c;
        byte[] bArrA = a5Var.a(se0Var.l(), new byte[0]);
        try {
            byte[] bArrB = a5Var.b(bArrA, new byte[0]);
            se0 se0Var2 = se0.f;
            w00 w00VarA = w00.a();
            int length = bArrB.length;
            cl clVar = new cl(bArrB, 0, length, false);
            try {
                if (length < 0) {
                    throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                int i = clVar.f + length;
                if (i > Integer.MAX_VALUE) {
                    throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                clVar.g = i;
                clVar.j();
                w50 w50VarJ = w50.j(se0Var2, clVar, w00VarA);
                clVar.a(0);
                w50.a(w50VarJ);
                if (!((se0) w50VarJ).equals(se0Var)) {
                    throw new GeneralSecurityException("cannot encrypt keyset");
                }
                xy xyVar = (xy) yy.f.k();
                zh zhVarC = zh.c(bArrA, 0, bArrA.length);
                xyVar.c();
                yy yyVar = (yy) xyVar.c;
                yyVar.getClass();
                yyVar.d = zhVarC;
                we0 we0VarA = de1.a(se0Var);
                xyVar.c();
                yy yyVar2 = (yy) xyVar.c;
                yyVar2.getClass();
                yyVar2.e = we0VarA;
                ((SharedPreferences.Editor) pn0Var.c).putString((String) pn0Var.d, xr.i(((yy) xyVar.a()).l())).apply();
            } catch (ic0 e) {
                throw new IllegalArgumentException(e);
            }
        } catch (ic0 unused) {
            s1.l("invalid keyset, corrupted key material");
        }
    }

    public void m(int i, Object obj, dq1 dq1Var) {
        zo1 zo1Var = (zo1) this.c;
        zo1Var.k(i, 3);
        dq1Var.c((ro1) obj, zo1Var.a);
        zo1Var.k(i, 4);
    }

    public void n(int i, Object obj, dq1 dq1Var) {
        ro1 ro1Var = (ro1) obj;
        zo1 zo1Var = (zo1) this.c;
        zo1Var.m((i << 3) | 2);
        zo1Var.m(ro1Var.a(dq1Var));
        dq1Var.c(ro1Var, zo1Var.a);
    }

    @Override // defpackage.ni
    public void onCancel() {
        ((v11) this.c).a();
    }

    public String toString() {
        switch (this.b) {
            case 2:
                return de1.a((se0) this.c).toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ tb0(int i, boolean z) {
        this.b = i;
    }

    public tb0(df dfVar, ArrayList arrayList) {
        this.b = 26;
        this.c = arrayList;
    }

    public tb0(zo1 zo1Var) {
        this.b = 27;
        Charset charset = lp1.a;
        this.c = zo1Var;
        zo1Var.a = this;
    }

    public tb0(int i) {
        this.b = i;
        switch (i) {
            case 14:
                this.c = new LinkedHashSet();
                break;
            default:
                this.c = new LinkedHashMap(0, 0.75f, true);
                break;
        }
    }

    public tb0(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.b = 0;
        if (Build.VERSION.SDK_INT >= 25) {
            this.c = new rb0(uri, clipDescription, uri2);
        } else {
            this.c = new ra(uri, clipDescription, uri2, 11);
        }
    }

    public /* synthetic */ tb0(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }
}
