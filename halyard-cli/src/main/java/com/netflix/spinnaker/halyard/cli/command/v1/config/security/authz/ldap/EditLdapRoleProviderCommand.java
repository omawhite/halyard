/*
 * Copyright 2017 Target, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.cli.command.v1.config.security.authz.ldap;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.security.authz.AbstractEditRoleProviderCommand;
import com.netflix.spinnaker.halyard.config.model.v1.security.GroupMembership;
import com.netflix.spinnaker.halyard.config.model.v1.security.LdapRoleProvider;
import com.netflix.spinnaker.halyard.config.model.v1.security.RoleProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Parameters(separators = "=")
public class EditLdapRoleProviderCommand extends AbstractEditRoleProviderCommand<LdapRoleProvider> {
  private final GroupMembership.RoleProviderType roleProviderType = GroupMembership.RoleProviderType.LDAP;

  @Parameter(
    names = "--url",
    description = "Placeholder description..."
  )
  private String url;

  @Parameter(
    names = "--manager-dn",
    description = "Placeholder description..."
  )
  private String managerDn;

  @Parameter(
    names = "--manager-password",
    description = "Placeholder description..."
  )
  private String managerPassword;

  @Parameter(
    names = "--user-dn-pattern",
    description = "Placeholder description..."
  )
  private String userDnPattern;

  @Parameter(
    names = "--group-search-base",
    description = "Placeholder description..."
  )
  private String groupSearchBase;

  @Parameter(
    names = "--group-search-filter",
    description = "Placeholder description..."
  )
  private String groupSearchFilter;

  @Parameter(
    names = "--group-role-attributes",
    description = "Placeholder description..."
  )
  private String groupRoleAttributes;

  @Override
  protected RoleProvider editRoleProvider(LdapRoleProvider roleProvider) {
    roleProvider.setUrl(isSet(url) ? url : roleProvider.getUrl());
    roleProvider.setManagerDn(isSet(managerDn) ? managerDn : roleProvider.getManagerDn());
    roleProvider.setManagerPassword(isSet(managerPassword) ? managerPassword : roleProvider.getManagerPassword());
    roleProvider.setUserDnPattern(isSet(userDnPattern) ? userDnPattern : roleProvider.getUserDnPattern());
    roleProvider.setGroupSearchBase(isSet(groupSearchBase) ? groupSearchBase : roleProvider.getGroupSearchBase());
    roleProvider.setGroupSearchFilter(isSet(groupSearchFilter) ? groupSearchFilter : roleProvider.getGroupSearchFilter());
    roleProvider.setGroupRoleAttributes(isSet(groupRoleAttributes) ? groupRoleAttributes : roleProvider.getGroupRoleAttributes());
    return roleProvider;
  }
}
