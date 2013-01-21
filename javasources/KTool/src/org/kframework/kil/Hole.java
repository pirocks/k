package org.kframework.kil;

import org.kframework.kil.loader.Constants;
import org.kframework.kil.visitors.Transformer;
import org.kframework.kil.matchers.Matcher;
import org.kframework.kil.visitors.Visitor;
import org.kframework.kil.visitors.exceptions.TransformerException;
import org.w3c.dom.Element;

/**
 * Represents {@code HOLE} in context declarations.
 * See {@link FreezerHole} for holes in freezers.
 */
public class Hole extends Term {
	public Hole(Element element) {
		super(element);
		this.sort = element.getAttribute(Constants.SORT_sort_ATTR);
	}

	public Hole(Hole hole) {
		super(hole);
	}

	public Hole(String sort) {
		super(sort);
	}

	public String toString() {
		return "[]:" + sort + " ";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ASTNode accept(Transformer visitor) throws TransformerException {
		return visitor.transform(this);
	}

  @Override
  public void accept(Matcher matcher, Term toMatch){
    matcher.match(this, toMatch);
  }

	@Override
	public Hole shallowCopy() {
		return new Hole(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!(obj instanceof Hole))
			return false;
		Hole hole = (Hole)obj;

		return this.sort.equals(hole.getSort());
	}

	@Override
	public int hashCode() {
		return sort.hashCode();
	}
}
