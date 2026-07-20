package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dz implements SharedPreferences {
    public final SharedPreferences a;
    public final ArrayList b = new ArrayList();
    public final a5 c;
    public final nt d;

    public dz(SharedPreferences sharedPreferences, a5 a5Var, nt ntVar) {
        this.a = sharedPreferences;
        this.c = a5Var;
        this.d = ntVar;
    }

    public static dz a(String str, Context context, bz bzVar, cz czVar) throws GeneralSecurityException {
        tb0 tb0VarG;
        tb0 tb0VarG2;
        int i = c61.a;
        ev0.a("TinkDeterministicAead", new y4(1));
        yb0.v(mt.b);
        ia0.a();
        ev0.a("TinkPublicKeySign", new y4(5));
        ev0.a("TinkPublicKeyVerify", new y4(6));
        yb0.v(s01.c);
        g7 g7Var = new g7(0);
        g7Var.e = bzVar.b;
        g7Var.z(context, "__androidx_security_crypto_encrypted_prefs_key_keyset__");
        String str2 = "android-keystore://" + str;
        if (!str2.startsWith("android-keystore://")) {
            zy.n("key URI must start with android-keystore://");
            return null;
        }
        g7Var.b = str2;
        h7 h7Var = new h7(g7Var);
        synchronized (h7Var) {
            tb0VarG = ((tb0) h7Var.f).g();
        }
        g7 g7Var2 = new g7(0);
        g7Var2.e = czVar.b;
        g7Var2.z(context, "__androidx_security_crypto_encrypted_prefs_value_keyset__");
        String str3 = "android-keystore://" + str;
        if (!str3.startsWith("android-keystore://")) {
            zy.n("key URI must start with android-keystore://");
            return null;
        }
        g7Var2.b = str3;
        h7 h7Var2 = new h7(g7Var2);
        synchronized (h7Var2) {
            tb0VarG2 = ((tb0) h7Var2.f).g();
        }
        Logger logger = ot.a;
        sq0 sq0VarC = ev0.c(tb0VarG);
        Iterator it = sq0VarC.a.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Collection) it.next()).iterator();
            while (it2.hasNext()) {
                if (!(((rq0) it2.next()).a instanceof lt)) {
                    s1.l("invalid Deterministic AEAD key material");
                    return null;
                }
            }
        }
        nt ntVar = new nt(sq0VarC);
        Logger logger2 = b5.a;
        sq0 sq0VarC2 = ev0.c(tb0VarG2);
        Iterator it3 = sq0VarC2.a.values().iterator();
        while (it3.hasNext()) {
            Iterator it4 = ((Collection) it3.next()).iterator();
            while (it4.hasNext()) {
                if (!(((rq0) it4.next()).a instanceof x4)) {
                    s1.l("invalid AEAD key material");
                    return null;
                }
            }
        }
        return new dz(context.getSharedPreferences("prefs_extra", 0), new a5(sq0VarC2), ntVar);
    }

    public static boolean d(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    public final String b(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            try {
                return new String(he.b(this.d.a(str.getBytes(StandardCharsets.UTF_8), "prefs_extra".getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        } catch (GeneralSecurityException e2) {
            s1.k("Could not encrypt key. ", e2.getMessage(), e2);
            return null;
        }
    }

    public final Object c(String str) {
        if (d(str)) {
            zy.b(str);
            return null;
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strB = b(str);
            String string = this.a.getString(strB, null);
            if (string != null) {
                byte[] bArrA = he.a(string);
                a5 a5Var = this.c;
                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(a5Var.b(bArrA, strB.getBytes(charset)));
                byteBufferWrap.position(0);
                int i = byteBufferWrap.getInt();
                int iR = l11.r(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? 0 : 6 : 5 : 4 : 3 : 2 : 1);
                if (iR == 0) {
                    int i2 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i2);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (!string2.equals("__NULL__")) {
                        return string2;
                    }
                } else if (iR == 1) {
                    ArraySet arraySet = new ArraySet();
                    while (byteBufferWrap.hasRemaining()) {
                        int i3 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i3);
                        byteBufferWrap.position(byteBufferWrap.position() + i3);
                        arraySet.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (arraySet.size() != 1 || !"__NULL__".equals(arraySet.valueAt(0))) {
                        return arraySet;
                    }
                } else {
                    if (iR == 2) {
                        return Integer.valueOf(byteBufferWrap.getInt());
                    }
                    if (iR == 3) {
                        return Long.valueOf(byteBufferWrap.getLong());
                    }
                    if (iR == 4) {
                        return Float.valueOf(byteBufferWrap.getFloat());
                    }
                    if (iR == 5) {
                        return Boolean.valueOf(byteBufferWrap.get() != 0);
                    }
                }
            }
            return null;
        } catch (GeneralSecurityException e) {
            s1.k("Could not decrypt value. ", e.getMessage(), e);
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (d(str)) {
            zy.b(str);
            return false;
        }
        return this.a.contains(b(str));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new az(this, this.a.edit());
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.a.getAll().entrySet()) {
            if (!d(entry.getKey())) {
                try {
                    String str = new String(this.d.b(he.a(entry.getKey()), "prefs_extra".getBytes()), StandardCharsets.UTF_8);
                    String str2 = str.equals("__NULL__") ? null : str;
                    map.put(str2, c(str2));
                } catch (GeneralSecurityException e) {
                    s1.k("Could not decrypt key. ", e.getMessage(), e);
                    return null;
                }
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Object objC = c(str);
        return (objC == null || !(objC instanceof Boolean)) ? z : ((Boolean) objC).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        Object objC = c(str);
        return (objC == null || !(objC instanceof Float)) ? f : ((Float) objC).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        Object objC = c(str);
        return (objC == null || !(objC instanceof Integer)) ? i : ((Integer) objC).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        Object objC = c(str);
        return (objC == null || !(objC instanceof Long)) ? j : ((Long) objC).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object objC = c(str);
        return (objC == null || !(objC instanceof String)) ? str2 : (String) objC;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Object objC = c(str);
        Set arraySet = objC instanceof Set ? (Set) objC : new ArraySet();
        return arraySet.size() > 0 ? arraySet : set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.remove(onSharedPreferenceChangeListener);
    }
}
