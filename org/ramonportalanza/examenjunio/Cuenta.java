package org.ramonportalanza.examenjunio;

import java.util.Objects;

public class Cuenta {

	private String numeroCuenta;
	private String detalleCuenta; // proveedores.
	private String tipoCuenta; // Debe o Haber.
	private double importe;
	private double totalDebe;
	private double totalHaber;

	public Cuenta() {
	}

	public Cuenta(String numeroCuenta, String detalleCuenta, String tipoCuenta, double importe) {
		this.numeroCuenta = numeroCuenta;
		this.detalleCuenta = detalleCuenta;
		this.tipoCuenta = tipoCuenta;
		this.importe = importe;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getDetalleCuenta() {
		return detalleCuenta;
	}

	public void setDetalleCuenta(String detalleCuenta) {
		this.detalleCuenta = detalleCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(detalleCuenta, importe, numeroCuenta, tipoCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(detalleCuenta, other.detalleCuenta)
				&& Double.doubleToLongBits(importe) == Double.doubleToLongBits(other.importe)
				&& Objects.equals(numeroCuenta, other.numeroCuenta) && Objects.equals(tipoCuenta, other.tipoCuenta)
				&& Double.doubleToLongBits(totalDebe) == Double.doubleToLongBits(other.totalDebe);
	}

	@Override
	public String toString() {

		return "Cuenta [numeroCuenta=" + numeroCuenta + ", detalleCuenta=" + detalleCuenta + ", tipoCuenta="
				+ tipoCuenta + ", importe=" + importe + "]";
	}

}
