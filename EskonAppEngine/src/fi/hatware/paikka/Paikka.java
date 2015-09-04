package fi.hatware.paikka;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.util.ArrayList;
import java.util.Collection;

import com.googlecode.objectify.Key;

@Entity
public class Paikka {

	@Parent Key<Osoitteet> osoitteet;
	@Index public String lahiosoite;
	@Id public Long id;
	public Collection<Double> lukemat = new ArrayList<Double>();

	public Paikka(){}
	
	public Paikka(String lahiosoite)
	{
		this.lahiosoite = lahiosoite;
		osoitteet = Key.create(Osoitteet.class, "osoitteet");  // Creating the Ancestor key
	}
}
