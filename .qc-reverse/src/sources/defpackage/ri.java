package defpackage;

import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ri {
    public final int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ CarouselLayoutManager c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ri(CarouselLayoutManager carouselLayoutManager, int i) {
        this(1);
        this.b = i;
        switch (i) {
            case 1:
                this.c = carouselLayoutManager;
                this(0);
                break;
            default:
                this.c = carouselLayoutManager;
                break;
        }
    }

    public final int a() {
        switch (this.b) {
            case 0:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.c;
                if (carouselLayoutManager.F0()) {
                    return carouselLayoutManager.n;
                }
                return 0;
        }
    }

    public ri(int i) {
        this.a = i;
    }
}
