package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pn1 {
    public static final int a = Runtime.getRuntime().availableProcessors();

    public static int a(String str, Bundle bundle) {
        if (bundle == null) {
            g(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            f(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        g(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static void b(Bundle bundle, String str, long j) {
        bundle.putString("playBillingLibraryVersion", str);
        bundle.putLong("billingClientSessionId", j);
    }

    public static Bundle c(boolean z, boolean z2, String str, long j) {
        Bundle bundle = new Bundle();
        b(bundle, str, j);
        if (z) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static df d(Intent intent, String str) {
        if (intent != null) {
            jl1 jl1VarA = df.a();
            jl1VarA.b = a(str, intent.getExtras());
            jl1VarA.c = e(str, intent.getExtras());
            return jl1VarA.b();
        }
        g("BillingHelper", "Got null intent!");
        jl1 jl1VarA2 = df.a();
        jl1VarA2.b = 6;
        jl1VarA2.c = "An internal error occurred.";
        return jl1VarA2.b();
    }

    public static String e(String str, Bundle bundle) {
        if (bundle == null) {
            g(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            f(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        g(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static void f(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i = 40000;
            while (!str2.isEmpty() && i > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i -= iMin;
            }
        }
    }

    public static void g(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static Bundle i(df dfVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", dfVar.a);
        bundle.putString("DEBUG_MESSAGE", dfVar.b);
        bundle.putInt("LOG_REASON", i - 1);
        return bundle;
    }

    public static Purchase j(String str, String str2) {
        if (str == null || str2 == null) {
            f("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            g("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
            return null;
        }
    }
}
