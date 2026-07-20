package defpackage;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreference;
import com.canhub.cropper.CropImageActivity;
import com.canhub.cropper.CropImageView;
import com.quickcursor.R;
import com.quickcursor.android.activities.WindowConfigActivity;
import com.quickcursor.android.activities.settings.MissingPermissions;
import com.quickcursor.android.activities.settings.TriggersSettings;
import com.quickcursor.android.preferences.WindowConfigPreference;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r1 implements zp0, hq, e4, ir0, aq0, jn0, w2, pf, q2, t31 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ r1(sf sfVar, of ofVar) {
        this.b = 4;
        this.c = ofVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                ((t1) obj2).k0.O(ce.valueOf((String) obj) == ce.vertical ? Integer.valueOf(R.drawable.icon_settings) : null);
                return true;
            case 1:
                ((t1) obj2).k0.O(ce.valueOf((String) obj) == ce.vertical ? Integer.valueOf(R.drawable.icon_settings) : null);
                return true;
            case 13:
                ((PreferenceCategory) ((lf0) obj2).n0).F(((Boolean) obj).booleanValue());
                return true;
            case 16:
                dy0 dy0Var = (dy0) obj2;
                dy0Var.k0.F(by0.valueOf((String) obj) == by0.force);
                SwitchPreference switchPreference = dy0Var.k0;
                if (!switchPreference.x) {
                    switchPreference.J(false);
                }
                return true;
            case 19:
                k00 k00Var = (k00) obj2;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i2 = 0;
                for (int i3 = 0; i3 < 3; i3++) {
                    StringBuilder sb = new StringBuilder("profile");
                    sb.append(i3);
                    i2 += ((SwitchPreference) k00Var.h0(sb.toString())).O ? 1 : 0;
                }
                return zBooleanValue || i2 >= 2;
            default:
                TriggersSettings triggersSettings = (TriggersSettings) obj2;
                tv0 tv0VarValueOf = tv0.valueOf((String) obj);
                b61.b(new s4(26), 1000L);
                triggersSettings.H(tv0VarValueOf);
                triggersSettings.E.u(tv0VarValueOf);
                xv0.d.c();
                return false;
        }
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        Bitmap bitmap;
        Uri data;
        int i = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 3:
                ya yaVar = (ya) obj2;
                d4 d4Var = (d4) obj;
                try {
                    if (d4Var.b == -1) {
                        Bundle extras = d4Var.c.getExtras();
                        if (extras.containsKey("android.intent.extra.shortcut.INTENT")) {
                            ((HashMap) yaVar.t0).put("intent", ((Intent) extras.get("android.intent.extra.shortcut.INTENT")).toUri(0));
                        } else {
                            yaVar.t0 = null;
                            jl1 jl1Var = new jl1(yaVar.o());
                            jl1Var.m(R.string.dialog_shortcut_picker_title);
                            jl1Var.g(R.string.dialog_shortcut_picker_unsupported_action);
                            ((x6) jl1Var.c).c = R.drawable.icon_about;
                            jl1Var.k(android.R.string.yes, null);
                            jl1Var.n();
                        }
                        if (extras.containsKey("android.intent.extra.shortcut.ICON") && (bitmap = (Bitmap) extras.get("android.intent.extra.shortcut.ICON")) != null) {
                            ((HashMap) yaVar.t0).put("ICON_BASE64_PNG", xr.j(bitmap));
                        }
                        yaVar.h0(false, false);
                    }
                } catch (Exception e) {
                    yaVar.t0 = null;
                    si0.b("Exception: " + e);
                    yb0.y(R.string.general_error_contact, 0);
                    return;
                }
                break;
            default:
                h7 h7Var = (h7) obj2;
                d4 d4Var2 = (d4) obj;
                CropImageActivity cropImageActivity = (CropImageActivity) ((sp1) h7Var.b).c;
                d4Var2.getClass();
                if (d4Var2.b != -1) {
                    cropImageActivity.G();
                } else {
                    Intent intent = d4Var2.c;
                    if (intent == null || (data = intent.getData()) == null) {
                        data = (Uri) h7Var.e;
                    }
                    if (data != null) {
                        cropImageActivity.A = data;
                        CropImageView cropImageView = cropImageActivity.C;
                        if (cropImageView != null) {
                            cropImageView.setImageUriAsync(data);
                        }
                    } else {
                        cropImageActivity.G();
                    }
                }
                break;
        }
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        int i2 = 2;
        Object obj = this.c;
        switch (i) {
            case 5:
                new kh(new s4(i2)).j0(((hh) obj).l(), "BrightnessCalibrateDialogFragment");
                break;
            case 6:
                new kh(new s4(i2)).j0(((ih) obj).l(), "BrightnessCalibrateDialogFragment");
                break;
            case 18:
                a11 a11Var = (a11) obj;
                jl1 jl1Var = new jl1(a11Var.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_reset_simple_triggers);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(12, a11Var));
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
            case 20:
                p91 p91Var = (p91) obj;
                jl1 jl1Var2 = new jl1(p91Var.o());
                jl1Var2.m(R.string.are_you_sure);
                jl1Var2.g(R.string.confirmation_reset_triggers_design_pie);
                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                jl1Var2.k(android.R.string.yes, new z2(18, p91Var));
                jl1Var2.h(android.R.string.no, null);
                jl1Var2.n();
                break;
            case 21:
                r91 r91Var = (r91) obj;
                jl1 jl1Var3 = new jl1(r91Var.o());
                jl1Var3.m(R.string.are_you_sure);
                jl1Var3.g(R.string.confirmation_reset_triggers_design_pie);
                ((x6) jl1Var3.c).c = R.drawable.icon_warning;
                jl1Var3.k(android.R.string.yes, new z2(19, r91Var));
                jl1Var3.h(android.R.string.no, null);
                jl1Var3.n();
                break;
            default:
                WindowConfigPreference windowConfigPreference = (WindowConfigPreference) obj;
                Intent intent = new Intent(windowConfigPreference.b, (Class<?>) WindowConfigActivity.class);
                intent.putExtra("rect", windowConfigPreference.O);
                windowConfigPreference.P.g0(intent, 10);
                break;
        }
        return true;
    }

    @Override // defpackage.pf
    public void d(yq0 yq0Var) {
        wj wjVar = (wj) this.c;
        if (yq0Var == yq0.no || yq0Var == yq0.pending) {
            si0.b("playProSecond: " + yq0Var);
            i70 i70Var = ud.a;
            try {
                si0.b("backupExpiredPreferences try...");
                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                editorEdit.putString("expiredPreferencesBackup", ud.a.i(ud.a()));
                editorEdit.apply();
                si0.b("backupExpiredPreferences success.");
            } catch (Exception e) {
                si0.b("backupExpiredPreferences error: " + e);
            }
            yb0.y(R.string.subscription_expired_toast, 1);
            zq0.b.a();
            CursorAccessibilityService.k(true);
            wjVar.recreate();
        }
    }

    @Override // defpackage.ir0
    public void e(df dfVar, ArrayList arrayList) {
        final of ofVar = (of) this.c;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            if (dfVar.a == 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    hr0 hr0Var = (hr0) it.next();
                    String str = hr0Var.f;
                    final String str2 = hr0Var.a().a;
                    final int i = 1;
                    if (str.contains("Sale ")) {
                        if (new Date().getTime() < simpleDateFormat.parse(str.split("Sale ")[1].trim()).getTime()) {
                            final int i2 = 0;
                            sf.h(new Runnable() { // from class: gf
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i3 = i2;
                                    String str3 = str2;
                                    of ofVar2 = ofVar;
                                    switch (i3) {
                                        case 0:
                                            ofVar2.a(str3, Boolean.TRUE);
                                            break;
                                        default:
                                            ofVar2.a(str3, Boolean.FALSE);
                                            break;
                                    }
                                }
                            });
                            return;
                        }
                    }
                    sf.h(new Runnable() { // from class: gf
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = i;
                            String str3 = str2;
                            of ofVar2 = ofVar;
                            switch (i3) {
                                case 0:
                                    ofVar2.a(str3, Boolean.TRUE);
                                    break;
                                default:
                                    ofVar2.a(str3, Boolean.FALSE);
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Exception unused) {
        }
        sf.h(new c(10, ofVar));
    }

    @Override // defpackage.t31
    public Object f() {
        SQLiteDatabase sQLiteDatabaseA;
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 23:
                dx0 dx0Var = ((vd1) obj).i;
                sQLiteDatabaseA = dx0Var.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + dx0Var.c.d()).execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                g7 g7Var = (g7) obj;
                sQLiteDatabaseA = ((dx0) g7Var.d).a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (cursorRawQuery.moveToNext()) {
                            ra raVarA = hd.a();
                            raVarA.R(cursorRawQuery.getString(1));
                            raVarA.e = vq0.b(cursorRawQuery.getInt(2));
                            String string = cursorRawQuery.getString(3);
                            raVarA.d = string == null ? null : Base64.decode(string, 0);
                            arrayList.add(raVarA.m());
                            break;
                        }
                        cursorRawQuery.close();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj2 = arrayList.get(i2);
                            i2++;
                            ((ra) g7Var.b).P((hd) obj2, 1, false);
                        }
                        return null;
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                } finally {
                }
        }
    }

    @Override // defpackage.w2
    public void g(n3 n3Var, Boolean bool) {
        MissingPermissions missingPermissions = (MissingPermissions) this.c;
        int i = MissingPermissions.D;
        missingPermissions.onBackPressed();
    }

    @Override // defpackage.jn0
    public Object h() {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 8:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e) {
                    tk0 tk0Var = xu0.a;
                    zy.l("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                    return null;
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Failed to invoke constructor '" + xu0.b(constructor) + "' with no args", e2);
                } catch (InvocationTargetException e3) {
                    zy.l("Failed to invoke constructor '" + xu0.b(constructor) + "' with no args", e3.getCause());
                    return null;
                }
            default:
                Class cls = (Class) obj;
                try {
                    return kd1.a.a(cls);
                } catch (Exception e4) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e4);
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bb  */
    @Override // defpackage.q2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(defpackage.i r23) {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r1.i(i):void");
    }

    public wi j(ra raVar) throws IOException {
        xi xiVar = (xi) this.c;
        URL url = (URL) raVar.c;
        String strL = lc1.L("CctTransportBackend");
        if (Log.isLoggable(strL, 4)) {
            Log.i(strL, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(xiVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.8 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) raVar.e;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    tb0 tb0Var = xiVar.a;
                    uc ucVar = (uc) raVar.d;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    od0 od0Var = (od0) tb0Var.c;
                    zd0 zd0Var = new zd0(bufferedWriter, od0Var.a, od0Var.b, od0Var.c, od0Var.d);
                    zd0Var.e(ucVar);
                    zd0Var.g();
                    zd0Var.b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    String strL2 = lc1.L("CctTransportBackend");
                    if (Log.isLoggable(strL2, 4)) {
                        Log.i(strL2, String.format("Status Code: %d", numValueOf));
                    }
                    lc1.p("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    lc1.p("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new wi(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new wi(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            wi wiVar = new wi(responseCode, null, cd.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return wiVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (ConnectException e) {
            e = e;
            lc1.r("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new wi(500, null, 0L);
        } catch (UnknownHostException e2) {
            e = e2;
            lc1.r("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new wi(500, null, 0L);
        } catch (IOException e3) {
            e = e3;
            lc1.r("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new wi(400, null, 0L);
        } catch (vy e4) {
            e = e4;
            lc1.r("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new wi(400, null, 0L);
        }
    }

    public boolean k(tb0 tb0Var, int i, Bundle bundle) {
        co sp1Var;
        AppCompatEditText appCompatEditText = (AppCompatEditText) this.c;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((sb0) tb0Var.c).g();
                Parcelable parcelable = (Parcelable) ((sb0) tb0Var.c).e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        sb0 sb0Var = (sb0) tb0Var.c;
        ClipData clipData = new ClipData(sb0Var.a(), new ClipData.Item(sb0Var.f()));
        if (i2 >= 31) {
            sp1Var = new sp1(clipData, 2);
        } else {
            eo eoVar = new eo();
            eoVar.c = clipData;
            eoVar.d = 2;
            sp1Var = eoVar;
        }
        sp1Var.p(sb0Var.h());
        sp1Var.setExtras(bundle);
        return uf1.j(appCompatEditText, sp1Var.build()) == null;
    }

    public /* synthetic */ r1(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }
}
