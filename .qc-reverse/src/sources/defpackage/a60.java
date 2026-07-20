package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a60 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ GestureCropImageView a;

    public a60(GestureCropImageView gestureCropImageView) {
        this.a = gestureCropImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        GestureCropImageView gestureCropImageView = this.a;
        float doubleTapTargetScale = gestureCropImageView.getDoubleTapTargetScale();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (doubleTapTargetScale > gestureCropImageView.getMaxScale()) {
            doubleTapTargetScale = gestureCropImageView.getMaxScale();
        }
        float currentScale = gestureCropImageView.getCurrentScale();
        oq oqVar = new oq(gestureCropImageView, currentScale, doubleTapTargetScale - currentScale, x, y);
        gestureCropImageView.z = oqVar;
        gestureCropImageView.post(oqVar);
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.d(-f, -f2);
        return true;
    }
}
