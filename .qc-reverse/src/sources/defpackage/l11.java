package defpackage;

import android.content.res.TypedArray;
import android.database.Cursor;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l11 {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};

    public static int a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        int i2 = 3;
        if (i != 3) {
            i2 = 4;
            if (i != 4) {
                return 0;
            }
        }
        return i2;
    }

    public static int b(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 3) {
            return i != 4 ? 0 : 5;
        }
        return 4;
    }

    public static String c(String str, char c) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String d(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = str.charAt(i);
            if (!Character.isLetter(cCharAt)) {
                i++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static /* synthetic */ int e(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            case 10:
                return 12;
            case 11:
                return 13;
            default:
                throw null;
        }
    }

    public static /* synthetic */ int f(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return -1;
            default:
                throw null;
        }
    }

    public static int g(int i, int i2, int i3) {
        return (Integer.hashCode(i) + i2) * i3;
    }

    public static ClassCastException h(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String i(String str, j30 j30Var, String str2) {
        return str + j30Var + str2;
    }

    public static String j(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String k(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder l(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n(Cursor cursor) throws Exception {
        boolean zIsTerminated;
        if (cursor instanceof AutoCloseable) {
            cursor.close();
            return;
        }
        if (!(cursor instanceof ExecutorService)) {
            if (cursor instanceof TypedArray) {
                ((TypedArray) cursor).recycle();
                return;
            } else if (cursor instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) cursor).release();
                return;
            } else {
                if (!(cursor instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) cursor).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) cursor;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static /* synthetic */ String o(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String p(int i) {
        switch (i) {
            case 1:
                return "ON";
            case 2:
                return "OFF";
            case 3:
                return "PAUSED_TEMPORARILY_APP";
            case 4:
                return "PAUSED_TIMED_DISABLE";
            case 5:
                return "PAUSED_BLACKLIST";
            case 6:
                return "PAUSED_LOCKSCREEN";
            case 7:
                return "PAUSED_KEYBOARD";
            case 8:
                return "PAUSED_S_PEN_DETACHED";
            case 9:
                return "PAUSED_DISABLED_RESOLUTION";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String q(int i) {
        switch (i) {
            case 1:
                return "design_quick_cursor";
            case 2:
                return "design_arrow1";
            case 3:
                return "design_arrow2";
            case 4:
                return "design_arrow3";
            case 5:
                return "design_arrow4";
            case 6:
                return "design_arrow5";
            case 7:
                return "design_arrow6";
            case 8:
                return "design_arrow7";
            case 9:
                return "design_arrow8";
            case 10:
                return "design_arrow9";
            case 11:
                return "design_arrow10";
            case 12:
                return "design_arrow11";
            case 13:
                return "design_arrow12";
            case 14:
                return "design_arrow13";
            case 15:
                return "design_arrow14";
            case 16:
                return "design_arrow15";
            case 17:
                return "design_arrow16";
            case 18:
                return "design_arrow17";
            case 19:
                return "design_arrow18";
            case 20:
                return "design_arrow19";
            case 21:
                return "design_hand1";
            case 22:
                return "design_hand2";
            case 23:
                return "design_hand3";
            case 24:
                return "design_hand4";
            case 25:
                return "design_hand5";
            case 26:
                return "design_hand6";
            case 27:
                return "design_crosshair1";
            case 28:
                return "design_crosshair2";
            case 29:
                return "design_crosshair3";
            case 30:
                return "design_crosshair4";
            case 31:
                return "design_crosshair5";
            case 32:
                return "design_crosshair6";
            case 33:
                return "design_crosshair7";
            case 34:
                return "design_crosshair8";
            case 35:
                return "custom";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int r(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String s(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "UNRECOGNIZED" : "NIST_P521" : "NIST_P384" : "NIST_P256" : "UNKNOWN_CURVE";
    }

    public static /* synthetic */ String t(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "UNRECOGNIZED" : "SHA512" : "SHA256" : "SHA1" : "UNKNOWN_HASH";
    }

    public static /* synthetic */ String u(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int v(String str) {
        if (str == null) {
            zy.r("Name is null");
            return 0;
        }
        if (str.equals("disabled")) {
            return 1;
        }
        if (str.equals("blacklist")) {
            return 2;
        }
        if (str.equals("whitelist")) {
            return 3;
        }
        zy.n("No enum constant com.quickcursor.repositories.PreferencesRepository.AppFilterMode.".concat(str));
        return 0;
    }

    public static /* synthetic */ int w(String str) {
        if (str == null) {
            zy.r("Name is null");
            return 0;
        }
        if (str.equals("design_quick_cursor")) {
            return 1;
        }
        if (str.equals("design_arrow1")) {
            return 2;
        }
        if (str.equals("design_arrow2")) {
            return 3;
        }
        if (str.equals("design_arrow3")) {
            return 4;
        }
        if (str.equals("design_arrow4")) {
            return 5;
        }
        if (str.equals("design_arrow5")) {
            return 6;
        }
        if (str.equals("design_arrow6")) {
            return 7;
        }
        if (str.equals("design_arrow7")) {
            return 8;
        }
        if (str.equals("design_arrow8")) {
            return 9;
        }
        if (str.equals("design_arrow9")) {
            return 10;
        }
        if (str.equals("design_arrow10")) {
            return 11;
        }
        if (str.equals("design_arrow11")) {
            return 12;
        }
        if (str.equals("design_arrow12")) {
            return 13;
        }
        if (str.equals("design_arrow13")) {
            return 14;
        }
        if (str.equals("design_arrow14")) {
            return 15;
        }
        if (str.equals("design_arrow15")) {
            return 16;
        }
        if (str.equals("design_arrow16")) {
            return 17;
        }
        if (str.equals("design_arrow17")) {
            return 18;
        }
        if (str.equals("design_arrow18")) {
            return 19;
        }
        if (str.equals("design_arrow19")) {
            return 20;
        }
        if (str.equals("design_hand1")) {
            return 21;
        }
        if (str.equals("design_hand2")) {
            return 22;
        }
        if (str.equals("design_hand3")) {
            return 23;
        }
        if (str.equals("design_hand4")) {
            return 24;
        }
        if (str.equals("design_hand5")) {
            return 25;
        }
        if (str.equals("design_hand6")) {
            return 26;
        }
        if (str.equals("design_crosshair1")) {
            return 27;
        }
        if (str.equals("design_crosshair2")) {
            return 28;
        }
        if (str.equals("design_crosshair3")) {
            return 29;
        }
        if (str.equals("design_crosshair4")) {
            return 30;
        }
        if (str.equals("design_crosshair5")) {
            return 31;
        }
        if (str.equals("design_crosshair6")) {
            return 32;
        }
        if (str.equals("design_crosshair7")) {
            return 33;
        }
        if (str.equals("design_crosshair8")) {
            return 34;
        }
        if (str.equals("custom")) {
            return 35;
        }
        zy.n("No enum constant com.quickcursor.repositories.PreferencesRepository.CursorDesign.".concat(str));
        return 0;
    }

    public static /* synthetic */ int[] x(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }
}
