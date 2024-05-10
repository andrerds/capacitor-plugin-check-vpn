import { WebPlugin } from '@capacitor/core';

import type { CheckVpnPlugin } from './definitions';

export class CheckVpnWeb extends WebPlugin implements CheckVpnPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
