package com.netflix.spinnaker.halyard.cli.command.v1.config.security.authn.ldap;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.security.authn.AbstractEditAuthnMethodCommand;
import com.netflix.spinnaker.halyard.config.model.v1.security.AuthnMethod;
import com.netflix.spinnaker.halyard.config.model.v1.security.Ldap;
import lombok.Getter;

@Parameters(separators = "=")
public class EditLdapCommand extends AbstractEditAuthnMethodCommand<Ldap> {
  @Getter
  private String shortDescription = "Configure authentication using a LDAP identity provider.";

  @Getter
  private String longDescription = String.join(" ", "placeholder text...markus says fix this.");

  @Getter
  private AuthnMethod.Method method = AuthnMethod.Method.LDAP;

  @Parameter(
      names = "--url",
      description = "ldap:// or ldaps:// url of the LDAP server"
  )
  private String url;

  @Parameter(
      names = "--user-dn-pattern",
      description = "Placeholder...uid={0},ou=users"
  )
  private String userDnPattern;

  @Parameter(
      names = "--user-search-base",
      description = "Placeholder..."
  )
  private String userSearchBase;

  @Parameter(
      names = "--user-search-filter",
      description = "Placeholder"
  )
  private String userSearchFilter;

  @Override
  protected AuthnMethod editAuthnMethod(Ldap l) {
    l.setUrl(isSet(url) ? url : l.getUrl());
    l.setUserDnPattern(isSet(userDnPattern) ? userDnPattern : l.getUserDnPattern());
    l.setUserSearchBase(isSet(userSearchBase) ? userSearchBase : l.getUserSearchBase());
    l.setUserSearchFilter(isSet(userSearchFilter) ? userSearchFilter : l.getUserSearchFilter());

    return l;
  }
}
