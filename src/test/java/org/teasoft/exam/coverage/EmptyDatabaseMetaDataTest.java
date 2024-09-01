/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import java.sql.SQLException;

import org.junit.Test;
import org.teasoft.honey.jdbc.EmptyDatabaseMetaData;

/**
 * @author Kingstar
 * @since  2.1
 */
public class EmptyDatabaseMetaDataTest {
	
	@Test
	public void test() throws SQLException{
		EmptyDatabaseMetaData ebm=new EmptyDatabaseMetaData();
		ebm.allProceduresAreCallable();
		ebm.allTablesAreSelectable();
		ebm.getURL();
		
		ebm.isReadOnly();
		ebm.nullsAreSortedHigh();
		ebm.nullsAreSortedLow();
		ebm.nullsAreSortedAtStart();
		ebm.nullsAreSortedAtEnd();
		ebm.getDriverMajorVersion();
		ebm.getDriverMinorVersion();
		ebm.usesLocalFiles();
		ebm.usesLocalFilePerTable();
		ebm.supportsMixedCaseIdentifiers();
		ebm.storesUpperCaseIdentifiers();
		ebm.storesLowerCaseIdentifiers();
		ebm.storesMixedCaseIdentifiers();
		ebm.supportsMixedCaseQuotedIdentifiers();
		ebm.storesUpperCaseQuotedIdentifiers();
		ebm.storesLowerCaseQuotedIdentifiers();
		ebm.storesMixedCaseQuotedIdentifiers();
		
		try{ ebm.getIdentifierQuoteString(); } catch (Exception e) {}
		try{ebm.getSQLKeywords();} catch (Exception e) {  }
		try{ebm.getNumericFunctions();} catch (Exception e) {  }
		try{ebm.getStringFunctions();} catch (Exception e) {  }
		try{ebm.getSystemFunctions 	();} catch (Exception e) {  }
		try{ebm.getSearchStringEscape();} catch (Exception e) {  }
		try{ebm.getExtraNameCharacters();} catch (Exception e) {  }
		
		try{ ebm.getUserName(); } catch (Exception e) {  }
		try{ebm.getDatabaseProductName(); } catch (Exception e) {  }
		try{ebm.getDatabaseProductVersion(); } catch (Exception e) {  }
		try{ebm.getDriverName(); } catch (Exception e) {  }
		try{ebm.getDriverVersion(); } catch (Exception e) {  }
		
		try{ebm.getSchemaTerm();} catch (Exception e) {  }
		try{ebm.getProcedureTerm();} catch (Exception e) {  }
		try{ebm.getCatalogTerm();} catch (Exception e) {  }
		try{ebm.getCatalogTerm();} catch (Exception e) {  }
		try{ebm.getCatalogSeparator();} catch (Exception e) {  }
		
		ebm.getTimeDateFunctions();
		ebm.supportsAlterTableWithAddColumn();
		ebm.supportsAlterTableWithDropColumn();
		ebm.supportsColumnAliasing();
		ebm.nullPlusNonNullIsNull();
		ebm.supportsConvert();
		ebm.supportsTableCorrelationNames();
		ebm.supportsDifferentTableCorrelationNames();
		ebm.supportsExpressionsInOrderBy();
		ebm.supportsOrderByUnrelated();
		ebm.supportsGroupBy();
		ebm.supportsGroupByUnrelated();
		ebm.supportsGroupByBeyondSelect();
		ebm.supportsLikeEscapeClause();
		ebm.supportsMultipleResultSets();
		ebm.supportsMultipleTransactions();
		ebm.supportsNonNullableColumns();
		ebm.supportsMinimumSQLGrammar();
		ebm.supportsCoreSQLGrammar();
		ebm.supportsExtendedSQLGrammar();
		ebm.supportsANSI92EntryLevelSQL();
		ebm.supportsANSI92IntermediateSQL();
		ebm.supportsANSI92FullSQL();
		ebm.supportsIntegrityEnhancementFacility();
		ebm.supportsOuterJoins();
		ebm.supportsFullOuterJoins();
		ebm.supportsLimitedOuterJoins();
		
		ebm.isCatalogAtStart();
		ebm.supportsSchemasInDataManipulation();
		ebm.supportsSchemasInProcedureCalls();
		ebm.supportsSchemasInTableDefinitions();
		ebm.supportsSchemasInIndexDefinitions();
		ebm.supportsSchemasInPrivilegeDefinitions();
		ebm.supportsCatalogsInDataManipulation();
		ebm.supportsCatalogsInProcedureCalls();
		ebm.supportsCatalogsInTableDefinitions();
		ebm.supportsCatalogsInIndexDefinitions();
		ebm.supportsCatalogsInPrivilegeDefinitions();
		ebm.supportsPositionedDelete();
		ebm.supportsPositionedUpdate();
		ebm.supportsSelectForUpdate();
		ebm.supportsStoredProcedures();
		ebm.supportsSubqueriesInComparisons();
		ebm.supportsSubqueriesInExists();
		ebm.supportsSubqueriesInIns();
		ebm.supportsSubqueriesInQuantifieds();
		ebm.supportsCorrelatedSubqueries();
		ebm.supportsUnion	();
		ebm.supportsUnionAll();
		ebm.supportsOpenCursorsAcrossCommit();
		ebm.supportsOpenCursorsAcrossRollback();
		ebm.supportsOpenStatementsAcrossCommit();
		ebm.supportsOpenStatementsAcrossRollback();
		ebm.getMaxBinaryLiteralLength();
		ebm.getMaxCharLiteralLength();
		ebm.getMaxColumnNameLength();
		ebm.getMaxColumnsInGroupBy();
		ebm.getMaxColumnsInIndex();
		ebm.getMaxColumnsInOrderBy();
		ebm.getMaxColumnsInSelect();
		ebm.getMaxColumnsInTable();
		ebm.getMaxConnections();
		ebm.getMaxCursorNameLength();
		ebm.getMaxIndexLength();
		ebm.getMaxSchemaNameLength();
		ebm.getMaxProcedureNameLength();
		ebm.getMaxCatalogNameLength();
		ebm.getMaxRowSize();
		ebm.doesMaxRowSizeIncludeBlobs();
		ebm.getMaxStatementLength();
		ebm.getMaxStatements();
		ebm.getMaxTableNameLength();
		ebm.getMaxTablesInSelect();
		ebm.getMaxUserNameLength();
		ebm.getDefaultTransactionIsolation();
		ebm.supportsTransactions();
		try{ebm.supportsTransactionIsolationLevel(0);} catch (Exception e) {  }
		ebm.supportsDataDefinitionAndDataManipulationTransactions();
		ebm.supportsDataManipulationTransactionsOnly();
		ebm.dataDefinitionCausesTransactionCommit();
		ebm.dataDefinitionIgnoredInTransactions();
		ebm.getTypeInfo();
		ebm.supportsBatchUpdates();
		ebm.getConnection();
		ebm.supportsSavepoints();
		ebm.supportsNamedParameters();
		ebm.supportsMultipleOpenResults();
		ebm.supportsGetGeneratedKeys();
		ebm.getResultSetHoldability();
		ebm.getDatabaseMajorVersion();
		ebm.getDatabaseMinorVersion();
		ebm.getJDBCMajorVersion();
		ebm.getJDBCMinorVersion();
		ebm.getSQLStateType();
		ebm.locatorsUpdateCopy();
		ebm.supportsStatementPooling();
		ebm.supportsStoredFunctionsUsingCallSyntax();
		ebm.autoCommitFailureClosesAllResultSets();
		ebm.generatedKeyAlwaysReturned();

		try{ebm.getSchemas();} catch (Exception e) {  }
		try{ebm.getCatalogs();} catch (Exception e) {  }
		try{ebm.getTableTypes();} catch (Exception e) {  }
		try{ebm.getRowIdLifetime();} catch (Exception e) {  }
		try{ebm.getClientInfoProperties();} catch (Exception e) {  }
		

		try{	ebm.getColumnPrivileges("", "", "", "");} catch (Exception e) {  }
		try{ebm.getTablePrivileges("", "","");} catch (Exception e) {  }
		try{ebm.getBestRowIdentifier("", "","",1,false);} catch (Exception e) {  }
		try{ebm.getVersionColumns("", "","");} catch (Exception e) {  } 
		try{ebm.getPrimaryKeys("", "","");} catch (Exception e) {  } 
		try{ebm.getImportedKeys("", "","");} catch (Exception e) {  } 
		try{ebm.getExportedKeys("", "","");} catch (Exception e) {  } 
		try{ebm.getSuperTypes("", "","");} catch (Exception e) {  } 
		try{ebm.getIndexInfo("", "","",false,false);} catch (Exception e) {  }
		try{ebm.getUDTs("", "","",new int[] {1,2});} catch (Exception e) {  }
		try{ebm.getSuperTables("", "","");} catch (Exception e) {  } 
		try{ebm.getAttributes("", "","","");} catch (Exception e) {  } 
		try{ebm.supportsResultSetHoldability(1);} catch (Exception e) {  } 
		try{ebm.getSchemas("","");} catch (Exception e) {  } 
		try{ebm.getFunctions("","","");} catch (Exception e) {  } 
		try{ebm.getFunctionColumns("","","","");} catch (Exception e) {  } 
		try{ebm.getPseudoColumns("","","","");} catch (Exception e) {  } 
		
		try{ebm.getClientInfoProperties();} catch (Exception e) {  }
		try{ebm.getClientInfoProperties();} catch (Exception e) {  }
		try{ebm.getClientInfoProperties();} catch (Exception e) {  }
		try{ebm.getClientInfoProperties();} catch (Exception e) {  }


		ebm.supportsResultSetType(0);
		ebm.ownUpdatesAreVisible(0);
		ebm.ownDeletesAreVisible(0);
		ebm.ownInsertsAreVisible(0);
		ebm.othersUpdatesAreVisible(0);
		ebm.othersDeletesAreVisible(0);
		ebm.othersInsertsAreVisible(0);
		ebm.updatesAreDetected(0);
		ebm.deletesAreDetected(0);
		ebm.insertsAreDetected(0);
		
		ebm.unwrap(null);
		ebm.isWrapperFor(null);
		ebm.supportsConvert(1, 1);
		ebm.getColumns("", "", "", "");
		ebm.supportsResultSetConcurrency(1, 1);

	}

}
