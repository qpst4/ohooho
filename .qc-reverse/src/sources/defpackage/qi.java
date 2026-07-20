package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qi extends wt0 {
    public final Paint a;
    public final List b;

    public qi() {
        Paint paint = new Paint();
        this.a = paint;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // defpackage.wt0
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        int iJ;
        Canvas canvas2;
        int iH;
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((oe0) it.next()).getClass();
            paint.setColor(wl.b(0.0f, -65281, -16776961));
            int I = 0;
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).E0()) {
                ri riVar = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (riVar.b) {
                    case 0:
                        break;
                    default:
                        I = riVar.c.K();
                        break;
                }
                float f = I;
                ri riVar2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (riVar2.b) {
                    case 0:
                        iH = riVar2.c.o;
                        break;
                    default:
                        CarouselLayoutManager carouselLayoutManager = riVar2.c;
                        iH = carouselLayoutManager.o - carouselLayoutManager.H();
                        break;
                }
                float f2 = iH;
                canvas2 = canvas;
                canvas2.drawLine(0.0f, f, 0.0f, f2, paint);
            } else {
                ri riVar3 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (riVar3.b) {
                    case 0:
                        I = riVar3.c.I();
                        break;
                }
                float f3 = I;
                ri riVar4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (riVar4.b) {
                    case 0:
                        CarouselLayoutManager carouselLayoutManager2 = riVar4.c;
                        iJ = carouselLayoutManager2.n - carouselLayoutManager2.J();
                        break;
                    default:
                        iJ = riVar4.c.n;
                        break;
                }
                canvas2 = canvas;
                canvas2.drawLine(f3, 0.0f, iJ, 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
