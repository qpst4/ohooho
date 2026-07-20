package defpackage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ud0 extends pd0 {
    public final Serializable b;

    public ud0(Boolean bool) {
        Objects.requireNonNull(bool);
        this.b = bool;
    }

    public static boolean h(ud0 ud0Var) {
        Serializable serializable = ud0Var.b;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // defpackage.pd0
    public final String c() {
        Serializable serializable = this.b;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return g().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final BigInteger d() {
        Serializable serializable = this.b;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (h(this)) {
            return BigInteger.valueOf(g().longValue());
        }
        String strC = c();
        tk0.c(strC);
        return new BigInteger(strC);
    }

    public final boolean e() {
        Serializable serializable = this.b;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(c());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ud0.class != obj.getClass()) {
            return false;
        }
        ud0 ud0Var = (ud0) obj;
        Serializable serializable = ud0Var.b;
        Serializable serializable2 = this.b;
        if (serializable2 == null) {
            return serializable == null;
        }
        if (h(this) && h(ud0Var)) {
            return ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) ? d().equals(ud0Var.d()) : g().longValue() == ud0Var.g().longValue();
        }
        if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
            return serializable2.equals(serializable);
        }
        if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
            return (serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : tk0.w(c())).compareTo(serializable instanceof BigDecimal ? (BigDecimal) serializable : tk0.w(ud0Var.c())) == 0;
        }
        double dF = f();
        double dF2 = ud0Var.f();
        if (dF != dF2) {
            return Double.isNaN(dF) && Double.isNaN(dF2);
        }
        return true;
    }

    public final double f() {
        return this.b instanceof Number ? g().doubleValue() : Double.parseDouble(c());
    }

    public final Number g() {
        Serializable serializable = this.b;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new sf0((String) serializable);
        }
        zy.f("Primitive is neither a number nor a string");
        return null;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.b;
        if (serializable == null) {
            return 31;
        }
        if (h(this)) {
            jDoubleToLongBits = g().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(g().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public ud0(Number number) {
        Objects.requireNonNull(number);
        this.b = number;
    }

    public ud0(String str) {
        Objects.requireNonNull(str);
        this.b = str;
    }
}
