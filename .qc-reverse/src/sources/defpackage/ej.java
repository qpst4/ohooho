package defpackage;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ej extends Property {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ej(Class cls, String str, int i) {
        super(cls, str);
        this.a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(((View) obj).getLayoutParams().width);
            case 6:
                return Float.valueOf(((View) obj).getLayoutParams().height);
            case 7:
                WeakHashMap weakHashMap = uf1.a;
                return Float.valueOf(((View) obj).getPaddingStart());
            case 8:
                WeakHashMap weakHashMap2 = uf1.a;
                return Float.valueOf(((View) obj).getPaddingEnd());
            case 9:
                return Float.valueOf(((SwitchCompat) obj).A);
            case 10:
                return Float.valueOf(ug1.a.n((View) obj));
            default:
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                hj hjVar = (hj) obj;
                PointF pointF = (PointF) obj2;
                hjVar.getClass();
                hjVar.a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                hjVar.b = iRound;
                int i = hjVar.f + 1;
                hjVar.f = i;
                if (i == hjVar.g) {
                    ug1.a(hjVar.e, hjVar.a, iRound, hjVar.c, hjVar.d);
                    hjVar.f = 0;
                    hjVar.g = 0;
                }
                break;
            case 1:
                hj hjVar2 = (hj) obj;
                PointF pointF2 = (PointF) obj2;
                hjVar2.getClass();
                hjVar2.c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                hjVar2.d = iRound2;
                int i2 = hjVar2.g + 1;
                hjVar2.g = i2;
                if (hjVar2.f == i2) {
                    ug1.a(hjVar2.e, hjVar2.a, hjVar2.b, hjVar2.c, iRound2);
                    hjVar2.f = 0;
                    hjVar2.g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                ug1.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                ug1.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 4:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                ug1.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case 5:
                View view4 = (View) obj;
                view4.getLayoutParams().width = ((Float) obj2).intValue();
                view4.requestLayout();
                break;
            case 6:
                View view5 = (View) obj;
                view5.getLayoutParams().height = ((Float) obj2).intValue();
                view5.requestLayout();
                break;
            case 7:
                View view6 = (View) obj;
                int iIntValue = ((Float) obj2).intValue();
                int paddingTop = view6.getPaddingTop();
                WeakHashMap weakHashMap = uf1.a;
                view6.setPaddingRelative(iIntValue, paddingTop, view6.getPaddingEnd(), view6.getPaddingBottom());
                break;
            case 8:
                View view7 = (View) obj;
                WeakHashMap weakHashMap2 = uf1.a;
                view7.setPaddingRelative(view7.getPaddingStart(), view7.getPaddingTop(), ((Float) obj2).intValue(), view7.getPaddingBottom());
                break;
            case 9:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 10:
                float fFloatValue = ((Float) obj2).floatValue();
                ug1.a.x((View) obj, fFloatValue);
                break;
            default:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
