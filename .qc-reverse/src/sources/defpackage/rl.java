package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.quickcursor.R;
import com.rarepebble.colorpicker.AlphaView;
import com.rarepebble.colorpicker.HueSatView;
import com.rarepebble.colorpicker.SwatchView;
import com.rarepebble.colorpicker.ValueView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rl extends FrameLayout {
    public final AlphaView b;
    public final EditText c;
    public final f9 d;
    public final SwatchView e;

    public rl(Context context) {
        super(context, null);
        f9 f9Var = new f9(2);
        this.d = f9Var;
        LayoutInflater.from(context).inflate(R.layout.picker, this);
        SwatchView swatchView = (SwatchView) findViewById(R.id.swatchView);
        this.e = swatchView;
        swatchView.getClass();
        ArrayList arrayList = (ArrayList) f9Var.d;
        arrayList.add(swatchView);
        HueSatView hueSatView = (HueSatView) findViewById(R.id.hueSatView);
        hueSatView.k = f9Var;
        arrayList.add(hueSatView);
        ValueView valueView = (ValueView) findViewById(R.id.valueView);
        valueView.l = f9Var;
        arrayList.add(valueView);
        AlphaView alphaView = (AlphaView) findViewById(R.id.alphaView);
        this.b = alphaView;
        alphaView.l = f9Var;
        arrayList.add(alphaView);
        EditText editText = (EditText) findViewById(R.id.hexEdit);
        this.c = editText;
        InputFilter[] inputFilterArr = e80.a;
        c80 c80Var = new c80(editText, f9Var);
        editText.addTextChangedListener(c80Var);
        arrayList.add(c80Var);
        editText.setFilters(e80.b);
        editText.setText(editText.getText());
    }

    public int getColor() {
        f9 f9Var = this.d;
        return Color.HSVToColor(f9Var.b, (float[]) f9Var.c);
    }

    public void setColor(int i) {
        setOriginalColor(i);
        setCurrentColor(i);
    }

    public void setCurrentColor(int i) {
        f9 f9Var = this.d;
        Color.colorToHSV(i, (float[]) f9Var.c);
        f9Var.b = Color.alpha(i);
        f9Var.f(null);
    }

    public void setOriginalColor(int i) {
        this.e.setOriginalColor(i);
    }
}
