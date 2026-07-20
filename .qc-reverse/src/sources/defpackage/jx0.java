package defpackage;

import android.content.Context;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;
import com.quickcursor.android.preferences.SalePreference;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jx0 implements Runnable {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Object d;

    public /* synthetic */ jx0(Context context, boolean z) {
        this.c = z;
        this.d = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Object obj = this.d;
        boolean z = this.c;
        switch (i) {
            case 0:
                ((SalePreference) obj).J(z);
                break;
            default:
                Context context = (Context) obj;
                int i2 = 0;
                if (z) {
                    try {
                        if (Build.VERSION.SDK_INT >= 30) {
                            int i3 = Integer.MAX_VALUE;
                            for (AccessibilityWindowInfo accessibilityWindowInfo : ((CursorAccessibilityService) context).getWindows()) {
                                Region region = new Region();
                                accessibilityWindowInfo.getRegionInScreen(region);
                                accessibilityWindowInfo.recycle();
                                int i4 = region.getBounds().left;
                                if (i4 < i3) {
                                    i3 = i4;
                                }
                                break;
                            }
                            if (i3 != Integer.MAX_VALUE) {
                                i2 = i3;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                ey0.g = i2;
                break;
        }
    }

    public /* synthetic */ jx0(SalePreference salePreference, boolean z) {
        this.d = salePreference;
        this.c = z;
    }
}
