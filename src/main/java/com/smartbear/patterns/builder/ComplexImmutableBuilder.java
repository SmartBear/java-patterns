package com.smartbear.patterns.builder;


public class ComplexImmutableBuilder
{
	public StrictModeConfigurator withConnectionTimeout( final int timeout )
	{
		return new StrictModeConfigurator()
		{
			@Override
			public NameConfigurator usingStrictMode( final boolean strict )
			{
				return new NameConfigurator()
				{
					@Override
					public NameSpaceConfigurator named( final String name )
					{
						return new NameSpaceConfigurator()
						{
							@Override
							public ContextConfigurator inNameSpace( final String namespace )
							{
								return new ContextConfigurator()
								{
									@Override
									public AspectConfigurator withContext( final String context )
									{
										return new AspectConfigurator()
										{
											@Override
											public Builder initializedTo( final long value )
											{
												return new Builder()
												{
													@Override
													public ComplexImmutable build()
													{
														return new ComplexImmutableObject( timeout, strict, name, namespace, context,
																value );
													}
												};
											}

											@Override
											public InitialValueConfigurator withAspect( final String aspect )
											{
												return new InitialValueConfigurator()
												{

													@Override
													public Builder initializedTo( final long value )
													{
														return new Builder()
														{
															@Override
															public ComplexImmutable build()
															{
																return new ExtraComplexImmutableObject( new ComplexImmutableObject(
																		timeout, strict, name, namespace, context, value ), aspect );
															}
														};
													};
												};
											}
										};
									}
								};
							}
						};
					}
				};
			}
		};
	}

	public static interface StrictModeConfigurator
	{
		NameConfigurator usingStrictMode( boolean strict );
	}

	public static interface NameConfigurator
	{
		NameSpaceConfigurator named( String name );
	}

	public static interface NameSpaceConfigurator
	{
		ContextConfigurator inNameSpace( String namespace );
	}

	public static interface ContextConfigurator
	{
		AspectConfigurator withContext( String context );
	}

	public static interface AspectConfigurator extends InitialValueConfigurator
	{
		InitialValueConfigurator withAspect( String aspect );
	}

	public static interface InitialValueConfigurator
	{
		Builder initializedTo( long value );
	}

	public static interface Builder
	{
		ComplexImmutable build();
	}
}