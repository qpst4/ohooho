package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class je extends Property {
    public final /* synthetic */ int a = 1;
    public final Object b;

    public je() {
        super(Matrix.class, "imageMatrixProperty");
        this.b = new Matrix();
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                return Float.valueOf(s7.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.G.getColorForState(extendedFloatingActionButton.getDrawableState(), ((ke) obj2).b.G.getDefaultColor()))));
            default:
                Matrix matrix = (Matrix) obj2;
                matrix.set(((ImageView) obj).getImageMatrix());
                return matrix;
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                Float f = (Float) obj2;
                int colorForState = extendedFloatingActionButton.G.getColorForState(extendedFloatingActionButton.getDrawableState(), ((ke) this.b).b.G.getDefaultColor());
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (s7.a(0.0f, Color.alpha(colorForState) / 255.0f, f.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                if (f.floatValue() != 1.0f) {
                    extendedFloatingActionButton.f(colorStateListValueOf);
                } else {
                    extendedFloatingActionButton.f(extendedFloatingActionButton.G);
                }
                break;
            default:
                ((ImageView) obj).setImageMatrix((Matrix) obj2);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je(ke keVar) {
        super(Float.class, "LABEL_OPACITY_PROPERTY");
        this.b = keVar;
    }
}
