package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l2 extends qg0 {
    public final /* synthetic */ int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
        this.q = 1;
    }

    @Override // defpackage.qg0
    public int b(View view, int i) {
        switch (this.q) {
            case 1:
                return 0;
            default:
                return super.b(view, i);
        }
    }

    @Override // defpackage.qg0
    public int c(View view, int i) {
        switch (this.q) {
            case 1:
                return 0;
            default:
                return super.c(view, i);
        }
    }

    @Override // defpackage.qg0
    public float d(DisplayMetrics displayMetrics) {
        switch (this.q) {
            case 2:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // defpackage.qg0
    public PointF f(int i) {
        switch (this.q) {
            case 1:
                return null;
            default:
                return super.f(i);
        }
    }

    @Override // defpackage.qg0
    public int g() {
        switch (this.q) {
            case 0:
                return -1;
            default:
                return super.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l2(Context context, int i) {
        super(context);
        this.q = i;
    }
}
