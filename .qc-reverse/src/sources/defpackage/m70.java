package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m70 extends View {
    public boolean b;

    public m70(Context context) {
        super(context);
        this.b = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.b = z;
    }

    public void setGuidelineBegin(int i) {
        kn knVar = (kn) getLayoutParams();
        if (this.b && knVar.a == i) {
            return;
        }
        knVar.a = i;
        setLayoutParams(knVar);
    }

    public void setGuidelineEnd(int i) {
        kn knVar = (kn) getLayoutParams();
        if (this.b && knVar.b == i) {
            return;
        }
        knVar.b = i;
        setLayoutParams(knVar);
    }

    public void setGuidelinePercent(float f) {
        kn knVar = (kn) getLayoutParams();
        if (this.b && knVar.c == f) {
            return;
        }
        knVar.c = f;
        setLayoutParams(knVar);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
