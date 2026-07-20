package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m30 extends AnimationSet implements Runnable {
    public final ViewGroup b;
    public final View c;
    public boolean d;
    public boolean e;
    public boolean f;

    public m30(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f = true;
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.f = true;
        if (this.d) {
            return !this.e;
        }
        if (!super.getTransformation(j, transformation)) {
            this.d = true;
            go0.a(this.b, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.d;
        ViewGroup viewGroup = this.b;
        if (z || !this.f) {
            viewGroup.endViewTransition(this.c);
            this.e = true;
        } else {
            this.f = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.f = true;
        if (this.d) {
            return !this.e;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.d = true;
            go0.a(this.b, this);
        }
        return true;
    }
}
