package defpackage;

import android.graphics.Paint;
import android.view.WindowManager;
import com.quickcursor.App;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x00 {
    public static final int[] i = {ey0.a(10) * 2, (ey0.e / 2) - ey0.a(10), ey0.e - (ey0.a(10) * 2)};
    public final Paint a;
    public final int b;
    public final int c;
    public long d;
    public boolean e;
    public int f;
    public int g;
    public final int h = (int) (((WindowManager) App.c.getSystemService("window")).getDefaultDisplay().getRefreshRate() / 5.0f);

    public x00() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setTextSize(ey0.a(10));
        paint.setColor(-65536);
        this.b = (int) ((ey0.c() / 2) - (paint.getTextSize() * 5.0f));
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        int[] iArr = i;
        this.c = iArr[threadLocalRandomCurrent.nextInt(0, iArr.length)];
        this.e = true;
    }
}
