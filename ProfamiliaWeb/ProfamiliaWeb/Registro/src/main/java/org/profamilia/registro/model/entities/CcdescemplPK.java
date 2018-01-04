package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CCDESCEMPL database table.
 * 
 */
@Embeddable
public class CcdescemplPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long cdenanno;

	private String cdectipide;

	private long cdeanumide;

	private long cdengrupo;

	private long cdensubgru;

	private String cdecservic;

	public CcdescemplPK() {
	}
	public long getCdenanno() {
		return this.cdenanno;
	}
	public void setCdenanno(long cdenanno) {
		this.cdenanno = cdenanno;
	}
	public String getCdectipide() {
		return this.cdectipide;
	}
	public void setCdectipide(String cdectipide) {
		this.cdectipide = cdectipide;
	}
	public long getCdeanumide() {
		return this.cdeanumide;
	}
	public void setCdeanumide(long cdeanumide) {
		this.cdeanumide = cdeanumide;
	}
	public long getCdengrupo() {
		return this.cdengrupo;
	}
	public void setCdengrupo(long cdengrupo) {
		this.cdengrupo = cdengrupo;
	}
	public long getCdensubgru() {
		return this.cdensubgru;
	}
	public void setCdensubgru(long cdensubgru) {
		this.cdensubgru = cdensubgru;
	}
	public String getCdecservic() {
		return this.cdecservic;
	}
	public void setCdecservic(String cdecservic) {
		this.cdecservic = cdecservic;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CcdescemplPK)) {
			return false;
		}
		CcdescemplPK castOther = (CcdescemplPK)other;
		return 
			(this.cdenanno == castOther.cdenanno)
			&& this.cdectipide.equals(castOther.cdectipide)
			&& (this.cdeanumide == castOther.cdeanumide)
			&& (this.cdengrupo == castOther.cdengrupo)
			&& (this.cdensubgru == castOther.cdensubgru)
			&& this.cdecservic.equals(castOther.cdecservic);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cdenanno ^ (this.cdenanno >>> 32)));
		hash = hash * prime + this.cdectipide.hashCode();
		hash = hash * prime + ((int) (this.cdeanumide ^ (this.cdeanumide >>> 32)));
		hash = hash * prime + ((int) (this.cdengrupo ^ (this.cdengrupo >>> 32)));
		hash = hash * prime + ((int) (this.cdensubgru ^ (this.cdensubgru >>> 32)));
		hash = hash * prime + this.cdecservic.hashCode();
		
		return hash;
	}
}