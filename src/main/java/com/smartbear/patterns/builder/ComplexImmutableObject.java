package com.smartbear.patterns.builder;

public final class ComplexImmutableObject implements ComplexImmutable
{
	private final long timeout;
	private final boolean strict;
	private final String name;
	private final String nameSpace;
	private final String context;
	private final long initialValue;
	private final int hashCode;

	@Override
	public String performAction()
	{
		return "Hi from " + this.toString();
	}

	ComplexImmutableObject( long timeout, boolean strict, String name, String nameSpace, String context,
			long initialValue )
	{
		this.timeout = timeout;
		this.strict = strict;
		this.name = name;
		this.nameSpace = nameSpace;
		this.context = context;
		this.initialValue = initialValue;
		this.hashCode = computeHashCode( timeout, strict, name, nameSpace, context, initialValue );
	}

	@Override
	public boolean equals( Object o )
	{
		if( this == o )
			return true;
		if( o == null || getClass() != o.getClass() )
			return false;

		ComplexImmutableObject that = ( ComplexImmutableObject )o;

		if( initialValue != that.initialValue )
			return false;
		if( strict != that.strict )
			return false;
		if( timeout != that.timeout )
			return false;
		if( !context.equals( that.context ) )
			return false;
		if( !name.equals( that.name ) )
			return false;
		if( !nameSpace.equals( that.nameSpace ) )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		return hashCode;
	}

	@Override
	public String toString()
	{
		return "ComplexImmutableObject{" + "timeout=" + timeout + ", strict=" + strict + ", name='" + name + '\''
				+ ", nameSpace='" + nameSpace + '\'' + ", context='" + context + '\'' + ", initialValue=" + initialValue
				+ '}';
	}

	private static final int computeHashCode( long timeout, boolean strict, String name, String nameSpace,
			String context, long initialValue )
	{
		int result = ( int )( timeout ^ ( timeout >>> 32 ) );
		result = 31 * result + ( strict ? 1 : 0 );
		result = 31 * result + name.hashCode();
		result = 31 * result + nameSpace.hashCode();
		result = 31 * result + context.hashCode();
		result = 31 * result + ( int )( initialValue ^ ( initialValue >>> 32 ) );
		return result;
	}
}
