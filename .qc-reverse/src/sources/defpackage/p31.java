package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p31 extends mg1 {
    public int f0;
    public float g0;
    public boolean h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;

    public final boolean B(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        int i = action & 255;
        if (i == 0) {
            this.g0 = motionEvent.getX();
            this.f0 = motionEvent.getPointerId(0);
        } else if (i == 1) {
            this.f0 = -1;
            this.j0 = false;
            this.k0 = false;
        } else {
            if (i == 2) {
                float x = motionEvent.getX(motionEvent.findPointerIndex(this.f0));
                float f = x - this.g0;
                if (f > 0.0f) {
                    if (!this.h0 && Math.abs(f) > 0.0f) {
                        this.k0 = true;
                    }
                    if (!this.k0) {
                        if (Math.abs(f) > 0.0f) {
                            this.j0 = false;
                        }
                        z = true;
                    }
                    z = false;
                } else {
                    if (f < 0.0f) {
                        if (!this.i0 && Math.abs(f) > 0.0f) {
                            this.j0 = true;
                        }
                        if (!this.j0) {
                            if (Math.abs(f) > 0.0f) {
                                this.k0 = false;
                            }
                            z = true;
                        }
                    }
                    z = false;
                }
                this.g0 = x;
                invalidate();
                return (this.j0 && !this.k0) || z;
            }
            if (i == 3) {
                this.f0 = -1;
                this.j0 = false;
                this.k0 = false;
            } else if (i == 6) {
                int i2 = (action & 65280) >> 8;
                if (motionEvent.getPointerId(i2) == this.f0) {
                    int i3 = i2 == 0 ? 1 : 0;
                    this.g0 = motionEvent.getX(i3);
                    this.f0 = motionEvent.getPointerId(i3);
                }
            }
        }
        z = false;
        if (this.j0) {
        }
    }

    @Override // defpackage.mg1, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (B(motionEvent)) {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    @Override // defpackage.mg1, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.h0 = bundle.getBoolean("SWIPE_RIGHT_ENABLED", true);
            this.i0 = bundle.getBoolean("SWIPE_LEFT_ENABLED", true);
            parcelable = bundle.getParcelable("SUPER");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // defpackage.mg1, android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle(4);
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putBoolean("SWIPE_RIGHT_ENABLED", this.h0);
        bundle.putBoolean("SWIPE_LEFT_ENABLED", this.i0);
        return bundle;
    }

    @Override // defpackage.mg1, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (B(motionEvent)) {
                if (super.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    public void setSwipeLeftEnabled(boolean z) {
        this.i0 = z;
    }

    public void setSwipeRightEnabled(boolean z) {
        this.h0 = z;
    }
}
