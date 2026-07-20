package defpackage;

import android.app.Notification;
import android.app.Person;
import android.graphics.drawable.Icon;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.text.PrecomputedText;
import android.view.DisplayCutout;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ju {
    public static void a(Notification.Builder builder, Person person) {
        builder.addPerson(person);
    }

    public static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static int c(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String d(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static int e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int g(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int h(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int i(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static PrecomputedText.Params j(AppCompatTextView appCompatTextView) {
        return appCompatTextView.getTextMetricsParams();
    }

    public static int k(Object obj) {
        return ((Icon) obj).getType();
    }

    public static Uri l(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static void m(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }

    public static void n(Notification.Action.Builder builder) {
        builder.setSemanticAction(0);
    }

    public static boolean o(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }

    public static Person p(np0 np0Var) {
        return new Person.Builder().setName(np0Var.a).setIcon(null).setUri(np0Var.b).setKey(np0Var.c).setBot(np0Var.d).setImportant(np0Var.e).build();
    }
}
